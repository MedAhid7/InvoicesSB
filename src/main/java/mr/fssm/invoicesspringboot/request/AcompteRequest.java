package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class AcompteRequest {
    private long montantPays;
    private InvoiceAllRequest invoice;
}
