package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("FOR")
public class Fournisseur extends Personne{
    @OneToMany(mappedBy = "fournisseur")
    private List<Produit> produits;

}
