package mr.fssm.invoicesspringboot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Modele implements Serializable {
    @Id
    private String modelId;
    @ManyToOne
    private Company company;
    //@ManyToMany(mappedBy = "models", fetch = FetchType.EAGER)
    //private Set<FactureDevis> factureDevis = new HashSet<>();
    //Attribut

    private String libelle;
    private Boolean etat;
    private String cl_titre_cps;
    private String cl_txt_cps;
    private String pl_titre_cps;
    private String pl_txt_cps;
    private String cl_titre_entt;
    private String cl_txt_entt;
    private String pl_titre_entt;
    private String pl_txt_entt;
    private String pl_bas;
    private String cl_bas;
    private String brd_table;
    private String cl_table;
    private String cl_total;
    private String pl_total;
    private Boolean casse;
    private String dispo_logo;
    private String dispo_ref;
    private String dispo_dest;
    private String dispo_dates;
    private String dispo_entt;
    private String dispo_liv;
    private Boolean personaliser;

}
