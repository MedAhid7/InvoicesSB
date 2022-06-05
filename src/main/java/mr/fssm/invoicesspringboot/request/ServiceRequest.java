package mr.fssm.invoicesspringboot.request;

import lombok.Data;
import mr.fssm.invoicesspringboot.Enum.TauxHoraire;
@Data
public class ServiceRequest {
    private double prix;
    private TauxHoraire tauxHoraire;
    private String libelle;
    private String description;
}
