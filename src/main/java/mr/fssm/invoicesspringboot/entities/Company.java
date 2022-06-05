package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Company {
    @Id
    private String companyId;
    private String nom;
    @Email
    private String email;
    private float taxe;
    private String categorie;
    private String raison;
    private String telephone1;
    private String telephone2;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<AddresseEntreprise> addresses;
    @OneToMany(mappedBy = "company")
    private List<Modele> models;
    @OneToMany(mappedBy = "company")
    private List<Personne> users;
    @OneToOne(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Logo_Entreprise company_logo;

}
