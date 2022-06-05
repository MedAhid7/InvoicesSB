package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.CompanyDto;
import mr.fssm.invoicesspringboot.exceptions.DevisNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse getCompany(String id) throws DevisNotFoundException, CompanyNotFoundException;
    List<CompanyResponse> listCompanies();
    CompanyDto createCompany(CompanyDto companyDto);
    CompanyDto updateCompany(String id, CompanyDto companyDto) throws CompanyNotFoundException;
    void deleteCompany(String id);
}
