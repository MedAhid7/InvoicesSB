package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

@Data
public class FournisseurDto {
    private String userId;
    private String nom;
    private String raisonSociale;
    private int telephone;
    private String nomContact;
    private String email;
    private AddressFournisseurDto address;
    private CompanyFourniDto company;
}
