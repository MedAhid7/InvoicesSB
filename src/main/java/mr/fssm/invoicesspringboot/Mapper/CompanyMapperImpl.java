package mr.fssm.invoicesspringboot.Mapper;

import mr.fssm.invoicesspringboot.Dto.CompanyDto;

import mr.fssm.invoicesspringboot.entities.Company;
import mr.fssm.invoicesspringboot.request.CompanyRequest;
import mr.fssm.invoicesspringboot.response.CompanyResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapperImpl {
    ModelMapper dtoMapper=new ModelMapper();
    public Company fromCompanyDTO(CompanyDto companyDto){
        Company company =dtoMapper.map(companyDto, Company.class);
        return company;
    }
    public CompanyDto fromCompany(Company company){
        CompanyDto companyDto=dtoMapper.map(company, CompanyDto.class);
        return companyDto;
    }
    public CompanyDto fromRequestToDto(CompanyRequest request){
        CompanyDto company=dtoMapper.map(request, CompanyDto.class);
        return company;
    }
    public CompanyResponse fromDtoToResponse(CompanyDto company){
        CompanyResponse response =dtoMapper.map(company, CompanyResponse.class);
        return response;
    }
    public CompanyResponse fromCompanyToResponse(Company company){
        CompanyResponse response =dtoMapper.map(company, CompanyResponse.class);
        return response;
    }
}
