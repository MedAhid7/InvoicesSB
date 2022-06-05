package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ModelDto implements Serializable {
    private String modelId;
    private String libelle;
    private Boolean etat;
    private String cl_titre_cps;
    private String cl_txt_cps;
    private String pl_titre_cps;
    private String pl_txt_cps;
    private String cl_titre_entt;
    private String cl_txt_entt;
    private String pl_titre_entt;
    private String pl_txt_entt;
    private String pl_bas;
    private String cl_bas;
    private String brd_table;
    private String cl_table;
    private String cl_total;
    private String pl_total;
    private Boolean casse;
    private String dispo_logo;
    private String dispo_ref;
    private String dispo_dest;
    private String dispo_dates;
    private String dispo_entt;
    private String dispo_liv;
    private Boolean personaliser;
    private CompanyMdelsDto company;
}
