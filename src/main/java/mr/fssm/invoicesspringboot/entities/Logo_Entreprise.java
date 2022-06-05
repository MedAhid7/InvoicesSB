package mr.fssm.invoicesspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("E")
public class Logo_Entreprise extends Logo{
    @OneToOne
    @JoinColumn(name = "companyId")
    private Company company;
}
