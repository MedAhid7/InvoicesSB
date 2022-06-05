package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "fournisseurId")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private List<LigneCommandes> ligneCommandes;
    private String reference;
    private String libelle;
    private String description;
    private float prix;//fait reference au cervice offert

}
