package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;
import mr.fssm.invoicesspringboot.Enum.Status;

import java.util.Date;
@Data
public class InvoiceDto{
    private Long id;
    private String codeInvoice;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;
    private Status statut;
    private String livraison;
    private AddressLivDto addressLivraison;
    private DevisAllDto devis;
    private UserAllDto client;
}
