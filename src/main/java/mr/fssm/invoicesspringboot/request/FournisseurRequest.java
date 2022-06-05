package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class FournisseurRequest {
    private String nom;
    private int telephone;
    private String nomContact;
    private String email;
    private String raisonSociale;
    private AddressAllRequest address;
    private CompanyAllRequest company;
}