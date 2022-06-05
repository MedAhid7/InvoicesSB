package mr.fssm.invoicesspringboot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mr.fssm.invoicesspringboot.Enum.TypeClient;

import javax.persistence.*;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("CLI")
public class Client extends Personne{
    @Enumerated(EnumType.STRING)
    private TypeClient typeClient;
    private String logo;
    @OneToMany(mappedBy = "client")
    private List<Devis>  devis;
}
