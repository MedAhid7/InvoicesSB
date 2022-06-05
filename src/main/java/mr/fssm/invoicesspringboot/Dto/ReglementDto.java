package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

@Data
public class ReglementDto {
    private Long id;
    private String raison_de;
    private InvoiceAllDto invoice;
}
