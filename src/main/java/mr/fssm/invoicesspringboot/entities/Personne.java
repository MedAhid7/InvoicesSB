package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 3)
public abstract class Personne {
    @Id
    private String userId;
    private String nom;
    private int telephone;
    private String nomContact;
    @Email
    private String email;
    private String raisonSociale;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AddressePersonne address;
    @ManyToOne
    private Company company;

}
