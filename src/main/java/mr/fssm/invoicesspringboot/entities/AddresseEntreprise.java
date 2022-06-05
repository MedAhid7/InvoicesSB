package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ENT")
@Data @NoArgsConstructor @AllArgsConstructor
public class AddresseEntreprise extends Addresse {
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
    private String typeAddr;
}
