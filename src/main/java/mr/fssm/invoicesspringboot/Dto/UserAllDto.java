package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

@Data
public class UserAllDto {
    private String userId;
    private String nom;
    private String email;
    private AddressAllDto address;

}
