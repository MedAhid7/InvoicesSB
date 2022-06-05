package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.LigneCommDto;
import mr.fssm.invoicesspringboot.Dto.ServiceDto;
import mr.fssm.invoicesspringboot.entities.Invoice;
import mr.fssm.invoicesspringboot.entities.LigneCommandes;
import mr.fssm.invoicesspringboot.entities.Produit;
import mr.fssm.invoicesspringboot.entities.Services;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.LignCmdNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;
import mr.fssm.invoicesspringboot.repository.InvoiceRepo;
import mr.fssm.invoicesspringboot.repository.LigneCommandesRepo;
import mr.fssm.invoicesspringboot.repository.ProduitRepo;
import mr.fssm.invoicesspringboot.repository.ServicesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class LigneCmdServiceImpl implements LigneCmdService {
    private final ProduitRepo produitRepo;
    private final ServicesRepo servicesRepo;
    private final InvoiceRepo invoiceRepo;
    private final LigneCommandesRepo ligneCommandesRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public LigneCommDto createLignCmd(LigneCommDto ligneCommDto) throws InvoiceNotFoundException, ProductNotFoundException {
        log.info("Saving new Product");
        Invoice invoice = invoiceRepo.findByCodeInvoice(ligneCommDto.getInvoice().getCodeInvoice());
        if (invoice == null){
            throw new InvoiceNotFoundException("Invoice not found");
        }
        Produit produit = produitRepo.findById(ligneCommDto.getProduit().getProductId()).orElse(null);
        if (produit == null){
            throw new ProductNotFoundException("Product not found");
        }
        Services service = servicesRepo.findById(ligneCommDto.getProduit().getProductId()).orElse(null);
        if (service == null){
            throw new ProductNotFoundException("Pas de Service Prestatisme trouver!");
        }


        LigneCommandes ligneCommandes = modelMapper.map(ligneCommDto, LigneCommandes.class);
        ligneCommandes.setId(UUID.randomUUID().toString());
        ligneCommandes.setProduit(produit);
        ligneCommandes.setInvoice(invoice);

        LigneCommandes newLignCmd = ligneCommandesRepo.save(ligneCommandes);
        LigneCommDto savedLignCmd= modelMapper.map(newLignCmd, LigneCommDto.class);
        return savedLignCmd;
    }
    @Override
    public LigneCommDto getLignCmd(String id) throws LignCmdNotFoundException {
        LigneCommandes ligneCommandes = ligneCommandesRepo.findById(id)
                .orElseThrow(()->new LignCmdNotFoundException("LignCmd not found"));
        return modelMapper.map(ligneCommandes, LigneCommDto.class);
    }
    @Override
    public List<LigneCommDto> listLignCmd() {
        List <LigneCommandes> ligneCommandes = ligneCommandesRepo.findAll();
        List <LigneCommDto> ligneCommDtos = ligneCommandes.stream()
                .map(ligneCmd -> modelMapper.map(ligneCmd, LigneCommDto.class))
                .collect(Collectors.toList());
        return ligneCommDtos;
    }
    @Override
    public LigneCommDto updateLignCmd(String id, LigneCommDto ligneCommDto) throws LignCmdNotFoundException {
        log.info("update Ligne Commande");
        LigneCommandes ligneCommand = ligneCommandesRepo.findById(id)
                .orElseThrow(()->new LignCmdNotFoundException("User not found"));
        Invoice invoice = invoiceRepo.findByCodeInvoice(ligneCommDto.getInvoice().getCodeInvoice());
        Produit produit = produitRepo.findById(ligneCommDto.getProduit().getProductId()).orElse(null);
        ligneCommand.setInvoice(invoice);
        ligneCommand.setProduit(produit);
        ligneCommand = modelMapper.map(ligneCommDto, LigneCommandes.class);
        LigneCommandes updateLigneCmd = ligneCommandesRepo.save(ligneCommand);
        return modelMapper.map(updateLigneCmd, LigneCommDto.class);
    }
    @Override
    public void deleteLigneCmd(String id){
        ligneCommandesRepo.deleteById(id);
    }

}
