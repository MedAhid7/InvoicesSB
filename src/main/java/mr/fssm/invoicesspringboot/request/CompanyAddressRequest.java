package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class CompanyAddressRequest {
    private String pays;
    private String ville;
    private String region_departement;
    private String code_postal;
    private String typeAddr;
}
