package mr.fssm.invoicesspringboot.response;

import lombok.Data;

@Data
public class ProduitsResponse {
    private Long productId;
    private String reference;
    private String libelle;
    private String description;
    private float prix;
    private UserResponse fournisseur;
}
