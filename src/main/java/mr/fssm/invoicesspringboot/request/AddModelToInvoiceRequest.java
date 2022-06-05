package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class AddModelToInvoiceRequest {
    private String modelId;
    private String codeInvoice;
}
