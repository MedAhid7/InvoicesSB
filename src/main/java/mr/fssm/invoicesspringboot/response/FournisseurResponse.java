package mr.fssm.invoicesspringboot.response;

import lombok.Data;

@Data
public class FournisseurResponse {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;
    private AddressResponse address;
    private CompanyMFCResponse company;
}
