package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.DevisDto;
import mr.fssm.invoicesspringboot.Dto.InvoiceDto;
import mr.fssm.invoicesspringboot.Enum.Status;
import mr.fssm.invoicesspringboot.Mapper.FactureMapperImpl;
import mr.fssm.invoicesspringboot.entities.*;
import mr.fssm.invoicesspringboot.exceptions.*;
import mr.fssm.invoicesspringboot.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
@Transactional
public class FactureDevisServiseImpl implements FactureDevisServise {
    private final FournisseurRepo fournisseurRepo;
    private final DevisRepo devisRepo;
    private final ClientRepo clientRepo;
    private final FactureMapperImpl dtoMapper;
    private final InvoiceRepo invoiceRepo;
    private final ModelRepo modelRepo;
/*


   *//* @Override
    public List<Facture> getFactures(int page, int limit) {
        List<Facture> factures = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<Facture> facturePage = factureDevisRepo.findAll(pageableRequest);
        List<Facture> facs =facturePage.getContent();
        for (Facture facture : facs){
            Facture fac = new Facture();
            BeanUtils.copyProperties(facture,fac);
            factures.add(fac);
        }
        return factures;
    }

*/
    //Ctree Facture
    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) throws ClientNontFoundException, DevisNontFoundException {
        log.info("Saving new Invoice");
        Client user = clientRepo.findById(invoiceDto.getClient().getUserId()).orElse(null);
        if (user == null){
            throw new ClientNontFoundException("User not found");
        }
        Devis devis = devisRepo.findByCodeDevis(invoiceDto.getDevis().getCodeDevis());
        if (devis == null){
            throw new DevisNontFoundException("Devis not found");
        }

        invoiceDto.getAddressLivraison().setInvoice(invoiceDto);

        Invoice invoice = dtoMapper.fromInvoiceDTO(invoiceDto);
        invoice.setCodeInvoice(UUID.randomUUID().toString());
        invoice.setStatut(Status.PENDING);
        invoice.setCreation(new Date());
        invoice.setDevis(devis);
        invoice.setClient(user);
        //invoice.set(user);

        Invoice newInvoice = invoiceRepo.save(invoice);
        InvoiceDto savedFacture = dtoMapper.fromInvoice(newInvoice);
        return savedFacture;
    }
    @Override
    public DevisDto createDevis(DevisDto devisDto) throws ClientNontFoundException {
        log.info("Saving new Devis");
        Client client = clientRepo.findById(devisDto.getClient().getUserId()).orElse(null);
        if (client == null){
            throw new ClientNontFoundException("User not found");
        }

        Devis devis  = dtoMapper.fromDevisDTO(devisDto);

        devis.setCodeDevis(UUID.randomUUID().toString());
        devis.setStatut(Status.PENDING);
        devis.setCreation(new Date());
        devis.setClient(client);

        Devis newDevis = devisRepo.save(devis);
        DevisDto savedDevis = dtoMapper.fromDevis(newDevis);
        return savedDevis;
    }
    @Override
    public InvoiceDto getInvoice(String codeInvoice) throws InvoiceNotFoundException {
       Invoice invoice = invoiceRepo.findByCodeInvoice(codeInvoice);
       if (invoice == null){
           throw new InvoiceNotFoundException("Invoice not found");
       }
        return dtoMapper.fromInvoice(invoice);
    }
    @Override
    public DevisDto getDevis(String codeDevis) throws DevisNotFoundException {
        Devis devis = devisRepo.findByCodeDevis(codeDevis);
        if (devis == null)
            throw new DevisNotFoundException("Devis not found");
        DevisDto devisDto = dtoMapper.fromDevis(devis);
        return devisDto;
    }
    @Override
    public List<InvoiceDto> listInvoices() {
        List <Invoice> invoices = invoiceRepo.findAll();
        List <InvoiceDto> invoiceDtos = invoices.stream()
                .map(invoice -> dtoMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
         return invoiceDtos;
    }
    @Override
    public List<DevisDto> listDevis() {
        List<Devis> devis = devisRepo.findAll();
        List<DevisDto> devisDtos = devis.stream()
                .map(devis1 -> dtoMapper.fromDevis(devis1))
                .collect(Collectors.toList());
        return devisDtos;
    }
    @Override
    public DevisDto updateDevis(Long id, DevisDto devisDto) throws DevisNotFoundException {
        Devis devis = devisRepo.findById(id)
                .orElseThrow(()->new DevisNotFoundException("Devis not found"));
        Client client = clientRepo.findById(devisDto.getClient().getUserId()).orElse(null);
        devis.setClient(client);
        devis = dtoMapper.fromDevisDTO(devisDto);
        Devis updateDevis = devisRepo.save(devis);
        log.info("update devis");
        return dtoMapper.fromDevis(updateDevis);
    }
    @Override
    public InvoiceDto updateInvoice(Long id, InvoiceDto invoiceDto) throws InvoiceNotFoundException {
        Invoice invoice = invoiceRepo.findById(id)
            .orElseThrow(()->new InvoiceNotFoundException("Invoice not found"));
        Devis devis = devisRepo.findByCodeDevis(invoiceDto.getDevis().getCodeDevis());
            //.orElseThrow(()-> new DevisNontFoundException("Devis not found"));
        Client client = clientRepo.findById(invoiceDto.getClient().getUserId()).orElse(null);

        invoice.setClient(client);
        invoice.setDevis(devis);
        invoice = dtoMapper.fromInvoiceDTO(invoiceDto);
        Invoice savedInvoice = invoiceRepo.save(invoice);
        log.info("update invoice");
        return dtoMapper.fromInvoice(savedInvoice);
    }

    @Override
    public void addModelToInvoice(String modelId, String codeInvoice) throws ModelNontFoundException, InvoiceNotFoundException {
        Modele modele = modelRepo.findById(modelId)
                .orElseThrow(()->new ModelNontFoundException("Model not found"));
        Invoice invoice = invoiceRepo.findByCodeInvoice(codeInvoice);
        if (invoice == null)
               throw new InvoiceNotFoundException("Invoice not found");
        invoice.getModels().add(modele);
        System.out.println("adding Model labelle: "+modele.getLibelle()+" To name Invoice : "+invoice.getNom());
    }
    @Override
    public void addModelToDevis(String modelId, String codeDevis) throws ModelNontFoundException, DevisNontFoundException {
        Modele modele = modelRepo.findById(modelId)
                .orElseThrow(()->new ModelNontFoundException("Model not found"));
        Devis devis = devisRepo.findByCodeDevis(codeDevis);
        if (devis == null)
               throw new DevisNontFoundException("Devis not found");
        devis.getModels().add(modele);
        System.out.println("adding Model labelle: "+modele.getLibelle()+" To name Devis : "+devis.getNom());
    }
    

    /*  public DevisDto saveDevis(DevisDto devisDto){
        log.info("saving new devis");
        Devis devis = dtoMapper.fromDevisDTO(devisDto);
        Devis savedDevis = devisRepo.save(devis);
        return dtoMapper.fromDevis(savedDevis);
    }*/
}
