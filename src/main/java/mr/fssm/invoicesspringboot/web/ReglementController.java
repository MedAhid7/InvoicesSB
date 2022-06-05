package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.CompanyDto;
import mr.fssm.invoicesspringboot.Dto.ReglementDto;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ReglementNotFoundException;
import mr.fssm.invoicesspringboot.request.ReglementRequest;
import mr.fssm.invoicesspringboot.response.CompanyResponse;
import mr.fssm.invoicesspringboot.response.ReglementResponse;
import mr.fssm.invoicesspringboot.service.ReglementService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reglement")
@RequiredArgsConstructor
public class ReglementController {
    private final ModelMapper modelMapper=new ModelMapper();
    private final ReglementService reglementService;

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ReglementResponse> saveReglement (@RequestBody @Valid ReglementRequest request) throws InvoiceNotFoundException {
        ReglementDto reglement = modelMapper.map(request, ReglementDto.class);
        ReglementDto createRegle = reglementService.createReglement(reglement);
        ReglementResponse response = modelMapper.map(createRegle, ReglementResponse.class);
        return new ResponseEntity<ReglementResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReglementResponse> getReglement(@PathVariable (name = "id") Long id) throws ReglementNotFoundException {
        ReglementDto reglement = reglementService.getReglement(id);
        ReglementResponse response = modelMapper.map(reglement, ReglementResponse.class);
        return new ResponseEntity<ReglementResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<ReglementResponse> listCompanies()  {
        List<ReglementDto> reglementDtos = reglementService.listReglements();
        List<ReglementResponse> responses = reglementDtos.stream()
                .map(reglement -> modelMapper.map(reglement, ReglementResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ReglementResponse> updateReglement(@PathVariable Long id, @RequestBody ReglementDto reglement) throws ReglementNotFoundException {
        reglement.setId(id);
        ReglementDto updateReglement = reglementService.updateReglement(id, reglement);
        ReglementResponse response = modelMapper.map(updateReglement, ReglementResponse.class);
        return new ResponseEntity<ReglementResponse>(response, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRegle(@PathVariable Long id){
        reglementService.deleteDReglement(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
