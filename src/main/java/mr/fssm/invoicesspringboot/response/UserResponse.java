package mr.fssm.invoicesspringboot.response;

import lombok.Data;

@Data
public class UserResponse {
    private String userId;
    private String nom;
    private String email;
    private AddressResponse address;
}
