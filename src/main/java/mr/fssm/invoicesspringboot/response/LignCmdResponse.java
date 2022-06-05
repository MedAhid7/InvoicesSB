package mr.fssm.invoicesspringboot.response;

import lombok.Data;

import java.util.List;

@Data
public class LignCmdResponse {
    private String id;
    private int quantite;
    private InvoiceAllResponse invoice;
    private ServiceResponse service;
    private ProduitsResponse produit;
}
