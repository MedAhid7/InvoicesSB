package mr.fssm.invoicesspringboot.Dto;

import lombok.Data;

import java.util.List;
@Data
public class CompanyClientDto {
    private String companyId;
    private String nom;
    private List<ClientDto> user;
}
