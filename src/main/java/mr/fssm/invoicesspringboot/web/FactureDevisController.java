package mr.fssm.invoicesspringboot.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.DevisDto;
import mr.fssm.invoicesspringboot.Dto.InvoiceDto;
import mr.fssm.invoicesspringboot.Mapper.FactureMapperImpl;
import mr.fssm.invoicesspringboot.exceptions.*;
import mr.fssm.invoicesspringboot.request.AddModelToDevisRequest;
import mr.fssm.invoicesspringboot.request.AddModelToInvoiceRequest;
import mr.fssm.invoicesspringboot.request.DevisRequest;
import mr.fssm.invoicesspringboot.request.InvoiceRequest;
import mr.fssm.invoicesspringboot.response.DevisResponse;
import mr.fssm.invoicesspringboot.response.InvoiceResponse;
import mr.fssm.invoicesspringboot.service.FactureDevisServise;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FactureDevisController {
    private final FactureDevisServise factureDevisServise;
    private final FactureMapperImpl dtoMapper;
    @PostMapping(value = "/invoice/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<InvoiceResponse> saveFacture (@RequestBody @Valid InvoiceRequest request) throws ClientNontFoundException, DevisNontFoundException {
        InvoiceDto invoice = dtoMapper.fromRequestToDto(request);
        InvoiceDto createInvoice = factureDevisServise.createInvoice(invoice);
        InvoiceResponse savedInvoice = dtoMapper.fromDtoToResponse(createInvoice);
        return new ResponseEntity<InvoiceResponse>(savedInvoice, HttpStatus.CREATED);
    }
    @GetMapping("/invoice/{id}")
    public ResponseEntity<InvoiceResponse> getFacture(@PathVariable (name = "id") String id) throws InvoiceNotFoundException {
       InvoiceDto invoice = factureDevisServise.getInvoice(id);
       InvoiceResponse response = dtoMapper.fromDtoToResponse(invoice);
        return new ResponseEntity<InvoiceResponse>(response, HttpStatus.OK);
    }
   @GetMapping("/invoice/list")
    public List<InvoiceResponse> listFactures() {
       List <InvoiceDto> invoices = factureDevisServise.listInvoices();
       List <InvoiceResponse> responses = invoices.stream()
               .map(invoice -> dtoMapper.fromDtoToResponse(invoice))
               .collect(Collectors.toList());
       return responses;
    }
    @PutMapping("/invoice/update/{id}")
    public ResponseEntity<InvoiceResponse> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto) throws InvoiceNotFoundException, DevisNontFoundException {
        invoiceDto.setId(id);
        InvoiceDto updateInvoice = factureDevisServise.updateInvoice(id, invoiceDto);
        InvoiceResponse savedInvoice = dtoMapper.fromDtoToResponse(updateInvoice);
        return new ResponseEntity<InvoiceResponse>(savedInvoice, HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "/devis/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DevisResponse> saveDevis(@RequestBody @Valid DevisRequest devisRequest) throws  InvoiceNotFoundException, ClientNontFoundException {
        DevisDto devisDto = dtoMapper.fromDevisRequesttoDto(devisRequest);
        DevisDto createDevis = factureDevisServise.createDevis(devisDto);
        DevisResponse savedDevis = dtoMapper.fromDevisDtoToResponse(createDevis);
        return new ResponseEntity<DevisResponse>(savedDevis, HttpStatus.CREATED);
    }
    @GetMapping("/devis/{id}")
    public ResponseEntity<DevisResponse> getDevis(@PathVariable (name = "id") String id) throws DevisNotFoundException {
        DevisDto devis = factureDevisServise.getDevis(id);
        DevisResponse response = dtoMapper.fromDevisDtoToResponse(devis);
        return new ResponseEntity<DevisResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/devis/list")
    public List<DevisResponse> ListDevis()  {
        List<DevisDto> devis = factureDevisServise.listDevis();
        List<DevisResponse> responses = devis.stream()
                .map(devi -> dtoMapper.fromDevisDtoToResponse(devi))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/devis/update/{id}")
    public ResponseEntity<DevisResponse> updateDevis(@PathVariable Long id, @RequestBody @Valid DevisDto request) throws DevisNotFoundException, FournisseurNontFoundException {
        request.setId(id);
        DevisDto updateDevis = factureDevisServise.updateDevis(id, request);
        DevisResponse savedDevis = dtoMapper.fromDevisDtoToResponse(updateDevis);
        return new ResponseEntity<DevisResponse>(savedDevis, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/devis/delete/{id}")
    public ResponseEntity<Object> deleteDevis(@PathVariable String id){
       // factureDevisServise.deleteDevis(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
    @PostMapping("/devis/addModel")
    public ResponseEntity <?>addModelToDevis(@Valid @RequestBody AddModelToDevisRequest from) throws DevisNontFoundException, ModelNontFoundException {
        factureDevisServise.addModelToDevis(from.getModelId(), from.getCodeDevis());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/invoice/addModel")
    public void addModelToInvoice(@Valid @RequestBody AddModelToInvoiceRequest from) throws ModelNontFoundException, InvoiceNotFoundException {
         factureDevisServise.addModelToInvoice(from.getModelId(), from.getCodeInvoice());
    }

}
