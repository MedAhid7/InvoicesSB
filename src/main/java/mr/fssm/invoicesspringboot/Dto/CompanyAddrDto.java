package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

@Data
public class CompanyAddrDto {
    private String pays;
    private String ville;
    private String region_departement;
    private String code_postal;
    private String typeAddr;
    private CompanyDto company;
}
