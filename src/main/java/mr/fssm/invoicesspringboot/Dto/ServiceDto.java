package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;
import mr.fssm.invoicesspringboot.Enum.TauxHoraire;


@Data
public class ServiceDto {
    private Long serviceId;
    private double prix;//fait reference au cervice offert
    private TauxHoraire tauxHoraire;
    private String libelle;
    private String description;
    private LigneCommDto ligneCommande ;
}
