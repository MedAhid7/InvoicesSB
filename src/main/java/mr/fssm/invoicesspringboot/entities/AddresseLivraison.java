package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("LIV")
public class AddresseLivraison extends Addresse {
    @OneToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
}
