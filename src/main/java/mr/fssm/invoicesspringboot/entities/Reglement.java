package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reglement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raison_de;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
}
