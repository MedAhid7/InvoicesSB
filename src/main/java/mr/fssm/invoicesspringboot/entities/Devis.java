package mr.fssm.invoicesspringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mr.fssm.invoicesspringboot.Enum.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Devis {
   // @GeneratedValue(generator = "UUID2")
   // @GenericGenerator(name="UUID2", strategy = "org.hibernate.id.UUIDGenerator")
   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private Long id;
    private String nom;
    private String codeDevis;
    private float taxe1;
    private float taxe2;
    private float remise;

    @Enumerated(EnumType.STRING)
    private Status statut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date validation;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date echeance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "invoice_models",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id")
    )
    private List<Modele> models = new ArrayList<>();

    @ManyToOne
    private Client client;
}
