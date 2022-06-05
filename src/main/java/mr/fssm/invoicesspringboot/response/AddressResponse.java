package mr.fssm.invoicesspringboot.response;

import lombok.Data;
@Data
public class AddressResponse {
    private Long id;
    private String pays;
    private String ville;
    private String region_departement;
    private String code_postal;
}