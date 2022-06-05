package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;

import mr.fssm.invoicesspringboot.Mapper.AcompteMapperImpl;
import mr.fssm.invoicesspringboot.exceptions.AcompteNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;

import mr.fssm.invoicesspringboot.request.AcompteRequest;

import mr.fssm.invoicesspringboot.response.AcompteResponse;

import mr.fssm.invoicesspringboot.service.AcompteService;

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
    private final AcompteMapperImpl dtoMapper;
    private final AcompteService acompteService;

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AcompteResponse> saveAcompte (@RequestBody @Valid AcompteRequest request) throws InvoiceNotFoundException {
        AcompteDto acompte = dtoMapper.fromRequestToDto(request);
        AcompteDto createAcompte = acompteService.createAcompte(acompte);
        AcompteResponse response = dtoMapper.fromDtoToResponse(createAcompte);
        return new ResponseEntity<AcompteResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AcompteResponse> getAcompte(@PathVariable (name = "id") Long id) throws AcompteNotFoundException {
        AcompteDto acompte = acompteService.getAcompte(id);
        AcompteResponse response = dtoMapper.fromDtoToResponse(acompte);
        return new ResponseEntity<AcompteResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<AcompteResponse> listAcomptes()  {
        List<AcompteDto> acompteDtos = acompteService.listAcompte();
        return acompteDtos.stream()
                .map(dtoMapper::fromDtoToResponse)
                .collect(Collectors.toList());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AcompteResponse> updateAcompte(@PathVariable Long id, @RequestBody AcompteDto acompte) throws AcompteNotFoundException {
        acompte.setId(id);
        AcompteDto updateAcompte = acompteService.updateAcompte(id, acompte);
        AcompteResponse response = dtoMapper.fromDtoToResponse(updateAcompte);
        return new ResponseEntity<AcompteResponse>(response, HttpStatus.ACCEPTED);
    }
}
