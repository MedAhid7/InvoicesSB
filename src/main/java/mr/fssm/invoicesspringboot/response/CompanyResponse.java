package mr.fssm.invoicesspringboot.response;

import lombok.Data;

import java.util.List;

@Data
public class CompanyResponse {
    private String companyId;
    private String nom;
    private String raison;
    private float taxe;
    private String categorie;
    private String telephone1;
    private String telephone2;
    private String email;
    private CompanyLogoRes company_logo;
    private List<CompanyAddressResponse> addresses;
}

