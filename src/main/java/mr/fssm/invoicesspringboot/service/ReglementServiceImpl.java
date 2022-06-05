package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import mr.fssm.invoicesspringboot.Dto.ReglementDto;
import mr.fssm.invoicesspringboot.entities.Invoice;
import mr.fssm.invoicesspringboot.entities.Reglement;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ReglementNotFoundException;
import mr.fssm.invoicesspringboot.repository.InvoiceRepo;
import mr.fssm.invoicesspringboot.repository.ReglementRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ReglementServiceImpl implements ReglementService {
    private final InvoiceRepo invoiceRepo;
    private final ReglementRepo reglementRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public ReglementDto createReglement(ReglementDto reglementDto) throws InvoiceNotFoundException {
        log.info("Saving new Reglement");
        Invoice invoice = invoiceRepo.findByCodeInvoice(reglementDto.getInvoice().getCodeInvoice());
        if (invoice == null){
            throw new InvoiceNotFoundException("Invoice not found");
        }
        Reglement reglement = modelMapper.map(reglementDto, Reglement.class);
        reglement.setInvoice(invoice);

        Reglement newRegl = reglementRepo.save(reglement);
        ReglementDto savedReglement= modelMapper.map(newRegl, ReglementDto.class);
        return savedReglement;
    }
    @Override
    public ReglementDto getReglement(Long id) throws ReglementNotFoundException {
        Reglement reglement = reglementRepo.findById(id)
                .orElseThrow(()->new ReglementNotFoundException("Reglement not found"));
        return modelMapper.map(reglement, ReglementDto.class);
    }
    @Override
    public List<ReglementDto> listReglements() {
        List <Reglement> reglements = reglementRepo.findAll();
        List <ReglementDto> reglementDtos = reglements.stream()
                .map(reglement -> modelMapper.map(reglement, ReglementDto.class))
                .collect(Collectors.toList());
        return reglementDtos;
    }
    @Override
    public ReglementDto updateReglement(Long id, ReglementDto reglementDto) throws ReglementNotFoundException {
        log.info("update Reglement");
        Reglement reglement = reglementRepo.findById(id)
                .orElseThrow(()->new ReglementNotFoundException("Reglement not found"));
        Invoice invoice = invoiceRepo.findByCodeInvoice(reglementDto.getInvoice().getCodeInvoice());
        reglement.setInvoice(invoice);
        reglement = modelMapper.map(reglementDto, Reglement.class);
        Reglement savedReglement = reglementRepo.save(reglement);
        return modelMapper.map(savedReglement, ReglementDto.class);
    }
    @Override
    public void deleteDReglement(Long id){
        reglementRepo.deleteById(id);
    }

}
