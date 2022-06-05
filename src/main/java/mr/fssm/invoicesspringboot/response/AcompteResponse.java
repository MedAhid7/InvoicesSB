package mr.fssm.invoicesspringboot.response;

import lombok.Data;

import java.util.Date;

@Data
public class AcompteResponse {
    private Long id;
    private Date datePays;
    private long montantPays;
    private InvoiceAllResponse invoice;
}
