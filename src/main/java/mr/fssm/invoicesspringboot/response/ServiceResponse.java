package mr.fssm.invoicesspringboot.response;

import lombok.Data;
import mr.fssm.invoicesspringboot.Enum.TauxHoraire;
@Data
public class ServiceResponse {
    private Long serviceId;
    private double prix;
    private TauxHoraire tauxHoraire;
    private String libelle;
    private String description;
}
