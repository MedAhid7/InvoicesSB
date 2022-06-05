package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

@Data
public class InvoiceAllDto {
    private Long id;
    private String codeInvoice;
    private String nom;
    private LigneCommDto ligneCommand;


}
