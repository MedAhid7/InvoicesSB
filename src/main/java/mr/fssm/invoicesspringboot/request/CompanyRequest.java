package mr.fssm.invoicesspringboot.request;

import lombok.Data;
import mr.fssm.invoicesspringboot.response.CompanyLogoRes;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CompanyRequest {
    @NotBlank(message = "Ce champ ne doit etre null!")
    @Size(min = 3, message = "minimum 3 caracteres")
    private String nom;
   // @NotBlank(message = "Ce champ ne doit pas être null!")
    private String raison;
    @NotBlank(message = "Ce champ ne doit pas être null!")
    @Email
    private String email;
   // @NotBlank(message = "Ce champ ne doit pas être null!")
    private String categorie;
   // @NotBlank(message = "Ce champ ne doit pas être null!")
    private String telephone1;
   // @NotBlank(message = "Ce champ ne doit pas être null!")
    private String telephone2;
   // @NotBlank(message = "Ce champ ne doit pas être null!")
    private float taxe;
   // @NotBlank(message = "Ce champ ne doit pas être null!")
    private CompanyLogoRequest company_logo;
    //@NotBlank(message = "Ce champ ne doit pas être null!")
    private List<CompanyAddressRequest> addresses;
}

