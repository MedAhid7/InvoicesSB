package mr.fssm.invoicesspringboot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class ErrorMessage {
    private String errorMessage;
    private Date timestamp;
}
