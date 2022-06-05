package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class ReglementRequest {
    private String raison_de;
    private InvoiceAllRequest invoice;
}
