package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.entities.Fournisseur;
import mr.fssm.invoicesspringboot.entities.Produit;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;
import mr.fssm.invoicesspringboot.repository.FournisseurRepo;
import mr.fssm.invoicesspringboot.repository.ProduitRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProduitServiceImpl implements ProduitService {
    private final FournisseurRepo fournisseurRepo;
    private final ProduitRepo produitRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public ProduitDto createProduct(ProduitDto produitDto) throws FournisseurNotFoundException {
        log.info("Saving new Product");
        Fournisseur user = fournisseurRepo.findById(produitDto.getFournisseur().getUserId()).orElse(null);
        if (user == null){
            throw new FournisseurNotFoundException("User not found");
        }
        Produit produit = modelMapper.map(produitDto, Produit.class);
        produit.setFournisseur(user);

        Produit newProduct = produitRepo.save(produit);
        ProduitDto savedProduct= modelMapper.map(newProduct, ProduitDto.class);
        return savedProduct;
    }
    @Override
    public ProduitDto getProduct(Long id) throws ProductNotFoundException {
        Produit produit = produitRepo.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found"));
        return modelMapper.map(produit, ProduitDto.class);
    }
    @Override
    public List<ProduitDto> listProducts() {
        List <Produit> produits = produitRepo.findAll();
        List <ProduitDto> produitDtos = produits.stream()
                .map(produit -> modelMapper.map(produit, ProduitDto.class))
                .collect(Collectors.toList());
        return produitDtos;
    }

    @Override
    public ProduitDto updateProduct(Long id, ProduitDto produitDto) throws ProductNotFoundException {
        log.info("update Product");
        Produit produit = produitRepo.findById(id)
                .orElseThrow(()->new ProductNotFoundException("User not found"));
        Fournisseur fournisseur = fournisseurRepo.findById(produitDto.getFournisseur().getUserId()).orElse(null);
        produit.setFournisseur(fournisseur);
        produit = modelMapper.map(produitDto, Produit.class);
        Produit saveProduct = produitRepo.save(produit);
        return modelMapper.map(saveProduct, ProduitDto.class);
    }
    @Override
    public void deleteProduit(Long id){
        produitRepo.deleteById(id);
    }

}
