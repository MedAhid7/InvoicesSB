package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LigneCommandes {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Produit produit;
    @ManyToOne(cascade = CascadeType.ALL)
    private Services  service;
    @OneToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
    private int quantite;

}
