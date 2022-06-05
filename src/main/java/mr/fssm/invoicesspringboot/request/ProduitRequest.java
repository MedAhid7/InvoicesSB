package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class ProduitRequest {
    private String reference;
    private String libelle;
    private String description;
    private float prix;
    private UserRequest fournisseur;
}
