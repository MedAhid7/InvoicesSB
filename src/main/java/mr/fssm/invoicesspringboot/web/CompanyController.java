package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.CompanyDto;
import mr.fssm.invoicesspringboot.Mapper.CompanyMapperImpl;
import mr.fssm.invoicesspringboot.exceptions.DevisNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.request.CompanyRequest;
import mr.fssm.invoicesspringboot.response.CompanyResponse;
import mr.fssm.invoicesspringboot.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapperImpl dtoMapper;
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                                        produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <CompanyResponse> saveCompany (@RequestBody @Valid CompanyRequest request){
        CompanyDto company = dtoMapper.fromRequestToDto(request);
        CompanyDto createCompany = companyService.createCompany(company);
        CompanyResponse response = dtoMapper.fromDtoToResponse(createCompany);
        return new ResponseEntity<CompanyResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompany(@PathVariable (name = "id") String id) throws CompanyNotFoundException, DevisNotFoundException {
        CompanyResponse response = companyService.getCompany(id);
        return new ResponseEntity<CompanyResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<CompanyResponse> listCompanies()  {
        return companyService.listCompanies();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyResponse> updateCompany(@PathVariable String id, @RequestBody CompanyDto company) throws CompanyNotFoundException {
        company.setCompanyId(id);
        CompanyDto newCompany = companyService.updateCompany(id, company);
        CompanyResponse response = dtoMapper.fromDtoToResponse(newCompany);
        return new ResponseEntity<CompanyResponse>(response, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCompany(@PathVariable String id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
