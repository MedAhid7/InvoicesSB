package mr.fssm.invoicesspringboot.response;

import lombok.Data;

@Data
public class ModelResponse {
    private String modelId;
    private String libelle;
    private Boolean etat;
    private Boolean personaliser;
    private CompanyMFCResponse company;


}
