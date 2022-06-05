package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;
import mr.fssm.invoicesspringboot.Dto.ReglementDto;
import mr.fssm.invoicesspringboot.exceptions.AcompteNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ReglementNotFoundException;
import mr.fssm.invoicesspringboot.request.AcompteRequest;
import mr.fssm.invoicesspringboot.request.ReglementRequest;
import mr.fssm.invoicesspringboot.response.AcompteResponse;
import mr.fssm.invoicesspringboot.response.ReglementResponse;
import mr.fssm.invoicesspringboot.service.AcompteService;
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
@RequestMapping("/api/v1/acompte")
@RequiredArgsConstructor
public class AcompteController {
    private final ModelMapper modelMapper=new ModelMapper();
    private final AcompteService acompteService;

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AcompteResponse> saveAcompte (@RequestBody @Valid AcompteRequest request) throws InvoiceNotFoundException {
        AcompteDto acompte = modelMapper.map(request, AcompteDto.class);
        AcompteDto createAcompte = acompteService.createAcompte(acompte);
        AcompteResponse response = modelMapper.map(createAcompte, AcompteResponse.class);
        return new ResponseEntity<AcompteResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AcompteResponse> getAcompte(@PathVariable (name = "id") Long id) throws AcompteNotFoundException {
        AcompteDto acompte = acompteService.getAcompte(id);
        AcompteResponse response = modelMapper.map(acompte, AcompteResponse.class);
        return new ResponseEntity<AcompteResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<AcompteResponse> listAcomptes()  {
        List<AcompteDto> acompteDtos = acompteService.listAcompte();
        List<AcompteResponse> responses = acompteDtos.stream()
                .map(acompte -> modelMapper.map(acompte, AcompteResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AcompteResponse> updateAcompte(@PathVariable Long id, @RequestBody AcompteDto acompte) throws AcompteNotFoundException {
        acompte.setId(id);
        AcompteDto updateAcompte = acompteService.updateAcompte(id, acompte);
        AcompteResponse response = modelMapper.map(updateAcompte, AcompteResponse.class);
        return new ResponseEntity<AcompteResponse>(response, HttpStatus.ACCEPTED);
    }
}
