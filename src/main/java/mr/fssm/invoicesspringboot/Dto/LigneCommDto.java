package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;
import mr.fssm.invoicesspringboot.entities.Services;

import java.util.List;

@Data
public class LigneCommDto {
    private String id;
    private int quantite;
    private ProduitDto produit;
    private ServiceDto  service;
    private InvoiceAllDto invoice;
}
