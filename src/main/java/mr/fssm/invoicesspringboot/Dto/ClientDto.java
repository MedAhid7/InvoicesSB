package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;
import mr.fssm.invoicesspringboot.Enum.TypeClient;
@Data
public class ClientDto {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;
    private TypeClient typeClient;
    private ClientLogoDto logo;
    private AddressClientDto address;
    private CompanyClientDto company;

}
