package mr.fssm.invoicesspringboot.request;

import lombok.Data;
import mr.fssm.invoicesspringboot.Enum.TypeClient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ClientRequest {
    @NotBlank(message = "Ce champ ne doit etre null!")
    @Size(min=3, message = "ce doit au moins avoir 3 caracteres!")
    private String nom;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private String raisonSociale;
  //  @NotBlank(message = "Ce champ ne doit etre null!")
    private int telephone;
    //@NotBlank(message = "Ce champ ne doit etre null!")
    private String nomContact;
    //@NotBlank(message = "Ce champ ne doit etre null!")
    @Email(message = "ce champ doit respecter le format Email")
    private String email;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private TypeClient typeClient;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private AddressAllRequest address;
    //@NotBlank(message = "Ce champ ne doit etre null!")
    private LogoRequest logo;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private CompanyAllRequest company;
}
