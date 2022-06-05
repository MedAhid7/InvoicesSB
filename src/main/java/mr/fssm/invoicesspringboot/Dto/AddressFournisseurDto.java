package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

@Data
public class AddressFournisseurDto {
    private Long id;
    private String pays;
    private String ville;
    private String region_departement;
    private String code_postal;
    private FournisseurDto user;
}
