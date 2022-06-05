package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class AcompteDto {
    private Long id;
    private Date datePays;
    private long montantPays;
    private InvoiceAllDto invoice;
}
