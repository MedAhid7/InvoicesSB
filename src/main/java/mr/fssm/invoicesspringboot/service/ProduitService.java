package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProduitService {
    ProduitDto createProduct(ProduitDto produitDto) throws FournisseurNotFoundException;

    ProduitDto getProduct(Long id) throws ProductNotFoundException;

    List<ProduitDto> listProducts();

    ProduitDto updateProduct(Long id, ProduitDto produitDto) throws ProductNotFoundException;

    void deleteProduit(Long id);
}
