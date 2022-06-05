package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;
import java.util.Collection;
import java.util.List;

@Data
public class ProduitDto {
    private Long productId;
    private String reference;
    private String libelle;
    private String description;
    private float prix;//fait reference au cervice offert
    private UserAllDto fournisseur;
    private List<LigneCommDto> ligneCommandes;
}