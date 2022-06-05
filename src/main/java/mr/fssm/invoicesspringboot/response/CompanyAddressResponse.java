package mr.fssm.invoicesspringboot.response;

import lombok.Data;

@Data
public class CompanyAddressResponse {
    private String pays;
    private String ville;
    private String region_departement;
    private String code_postal;
    private String typeAddr;
   // private CompanyResponse company;
}
