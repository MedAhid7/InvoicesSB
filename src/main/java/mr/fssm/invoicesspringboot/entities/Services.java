package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mr.fssm.invoicesspringboot.Enum.TauxHoraire;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Services {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private double prix;//fait reference au cervice offert
    @Enumerated(EnumType.STRING)
    private TauxHoraire tauxHoraire;
    private String libelle;
    private String description;
    @OneToMany(mappedBy = "service")
    private List<LigneCommandes>  ligneCommande;
}
