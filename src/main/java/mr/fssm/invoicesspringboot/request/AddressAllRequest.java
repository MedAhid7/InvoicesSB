package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class AddressAllRequest {
    private String pays;
    private String ville;
    private String region_departement;
    private String code_postal;
}

