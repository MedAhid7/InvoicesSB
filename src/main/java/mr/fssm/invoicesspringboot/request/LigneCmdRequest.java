package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class LigneCmdRequest {
    private int quantite;
    private InvoiceAllRequest invoice;
    private ServiceRequest service;
    private ProduitLignCmdRequest produit;
}
