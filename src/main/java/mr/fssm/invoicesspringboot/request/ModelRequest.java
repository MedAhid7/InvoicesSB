package mr.fssm.invoicesspringboot.request;

import lombok.Data;

@Data
public class ModelRequest {
    private String libelle;
    private Boolean etat;
    private Boolean personaliser;
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
   // @NotBlank(message = "l'Id de l'entreprise de void pas être null!")
    private CompanyAllRequest company;
}
