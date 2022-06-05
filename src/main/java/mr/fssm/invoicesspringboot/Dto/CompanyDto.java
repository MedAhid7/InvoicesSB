package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

import java.util.List;
@Data
public class CompanyDto {
    private String companyId;
    private String raison;
    private String nom;
    private float taxe;
    private String categorie;
    private String telephone1;
    private String telephone2;
    private String email;
    private CompanyLogoDto company_logo;
    private List<CompanyAddrDto> addresses;
}
