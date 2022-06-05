package mr.fssm.invoicesspringboot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Invoice extends Devis{
    private String codeInvoice;
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<Acompte> acomptes;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<Reglement> reglements;
    private String livraison;
    @OneToOne(mappedBy = "invoice",cascade = CascadeType.ALL)
    private AddresseLivraison addressLivraison;
    @ManyToOne
    private Devis devis;
    @ManyToOne
    private Client client;
    @OneToOne(mappedBy = "invoice")
    private LigneCommandes ligneCommand;
}
