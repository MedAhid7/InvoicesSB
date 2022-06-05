package mr.fssm.invoicesspringboot.request;

import lombok.Data;
import mr.fssm.invoicesspringboot.Dto.DevisAllDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class InvoiceRequest {
    @NotBlank(message = "Ce champ ne doit etre null!")
    @Size(min=3, message = "au moins 3 caracteres!")
    private String nom;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date validation;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date echeance;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float taxe1;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float taxe2;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float remise;
    private String livraison;
  //  @NotBlank(message = "Ce champ ne doit etre null!")
    private UserRequest client;
   // @NotBlank(message = "Ce champ ne doit etre null!")
  //  @NotBlank(message = "Ce champ ne doit etre null!")
    private AddressAllRequest addressLivraison;
    private DevisAllRequest devis;

}
