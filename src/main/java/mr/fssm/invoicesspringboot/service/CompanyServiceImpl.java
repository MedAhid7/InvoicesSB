package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.CompanyAddrDto;
import mr.fssm.invoicesspringboot.Dto.CompanyDto;
import mr.fssm.invoicesspringboot.Mapper.CompanyMapperImpl;
import mr.fssm.invoicesspringboot.entities.Company;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.repository.CompanyRepo;

import mr.fssm.invoicesspringboot.response.CompanyResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapperImpl dtoMapper;
    private final CompanyRepo companyRepo;
    @Override
    public CompanyResponse getCompany(String id) throws CompanyNotFoundException {
        Company company = companyRepo.findById(id)
                .orElseThrow(()->new CompanyNotFoundException("Company not found"));
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(company, CompanyResponse.class);
    }
    @Override
    public List<CompanyResponse> listCompanies() {
        List <Company> companies = companyRepo.findAll();
        List <CompanyResponse> companyResponses = companies.stream()
                .map(company -> dtoMapper.fromCompanyToResponse(company))
                .collect(Collectors.toList());
        return companyResponses;
    }
    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        log.info("saving new Company");

        for(int i=0; i<companyDto.getAddresses().size(); i++ ){
            CompanyAddrDto addressDto = companyDto.getAddresses().get(i);
            addressDto.setCompany(companyDto);
            companyDto.getAddresses().set(i, addressDto);
        }
      //  invoiceDto.getAddressLivraison().setInvoice(invoiceDto);

        companyDto.getCompany_logo().setCompany(companyDto);

        Company company = dtoMapper.fromCompanyDTO(companyDto);
        company.setCompanyId(UUID.randomUUID().toString());
        Company newCompany = companyRepo.save(company);
        CompanyDto savedCompany = dtoMapper.fromCompany(newCompany);
        return savedCompany;
    }
    @Override
    public CompanyDto updateCompany(String id, CompanyDto companyDto) throws CompanyNotFoundException {
        log.info("Undate an invoice");
        Company company = companyRepo.findById(id)
                .orElseThrow(()->new CompanyNotFoundException("Company id not found"));
        company = dtoMapper.fromCompanyDTO(companyDto);
        Company savedCompany = companyRepo.save(company);
        return dtoMapper.fromCompany(savedCompany);
    }
    @Override
    public void deleteCompany(String id){
        companyRepo.deleteById(id);
    }
}
