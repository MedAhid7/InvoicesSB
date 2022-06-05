package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Acompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datePays;
    private long montantPays;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
}
