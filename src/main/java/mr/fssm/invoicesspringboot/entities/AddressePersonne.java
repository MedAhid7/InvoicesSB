package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("PER")
public class AddressePersonne extends Addresse {
    @OneToOne
    @JoinColumn(name = "userId")
    private Personne user;
}
