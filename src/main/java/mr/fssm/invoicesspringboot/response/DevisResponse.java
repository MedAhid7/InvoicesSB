package mr.fssm.invoicesspringboot.response;

import lombok.Data;

import mr.fssm.invoicesspringboot.Enum.Status;

import java.util.Date;
@Data
public class DevisResponse {
    private String codeDevis;
    private String nom;
    private Date creation;
    private Date validation;
    private Date echeance;
    private float taxe1;
    private float taxe2;
    private float remise;
    private Status statut;
    private UserResponse client;

}