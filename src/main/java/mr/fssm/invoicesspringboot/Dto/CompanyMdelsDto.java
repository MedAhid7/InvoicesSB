package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

import java.util.List;
@Data
public class CompanyMdelsDto {
    private String companyId;
    private String nom;
    private List<ModelDto> models;
}
