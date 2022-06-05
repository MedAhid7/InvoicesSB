package mr.fssm.invoicesspringboot.response;

import lombok.Data;

@Data
public class ReglementResponse {
    private String raison_de;
    private InvoiceAllResponse invoice;
}
