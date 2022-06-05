package mr.fssm.invoicesspringboot.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class DevisRequest {
    @NotBlank(message = "Ce champ ne doit etre null!")
    @Size(min=3, message = "au moins 3 caracteres!")
    private String nom;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date validation;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private Date echeance;
  //  @NotBlank(message = "Ce champ ne doit etre null!")
    private float taxe1;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float taxe2;
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private float remise;
   // @NotBlank(message = "Ce champ ne doit etre null!")
   // @NotBlank(message = "Ce champ ne doit etre null!")
    private UserRequest client;
}
