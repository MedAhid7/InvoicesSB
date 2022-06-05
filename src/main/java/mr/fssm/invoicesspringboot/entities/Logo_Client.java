package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("C")
public class Logo_Client extends Logo{
    @OneToOne
    @JoinColumn(name = "userId")
    private Client user;
}
