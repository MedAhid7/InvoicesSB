package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.Dto.ServiceDto;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;
import mr.fssm.invoicesspringboot.request.ProduitRequest;
import mr.fssm.invoicesspringboot.request.ServiceRequest;
import mr.fssm.invoicesspringboot.response.ProduitsResponse;
import mr.fssm.invoicesspringboot.response.ServiceResponse;
import mr.fssm.invoicesspringboot.service.ProduitService;
import mr.fssm.invoicesspringboot.service.ServicesService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/service")
@RequiredArgsConstructor
public class ServicesController {
    private final ServicesService servicesService;
    private final ModelMapper modelMapper = new ModelMapper();
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ServiceResponse> saveService (@RequestBody @Valid ServiceRequest request) {
        ServiceDto service= modelMapper.map(request, ServiceDto.class);
        ServiceDto createService = servicesService.createService(service);
        ServiceResponse response = modelMapper.map(createService, ServiceResponse.class);
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getService(@PathVariable (name = "id") Long id) throws ProductNotFoundException {
        ServiceDto service = servicesService.getService(id);
        ServiceResponse response = modelMapper.map(service, ServiceResponse.class);
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<ServiceResponse> listServices()  {
        List<ServiceDto> serviceDtos = servicesService.listServices();
        List<ServiceResponse> responses = serviceDtos.stream()
                .map(service -> modelMapper.map(service, ServiceResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceResponse> updateProduct(@PathVariable Long id, @RequestBody ServiceDto service) throws ProductNotFoundException {
        service.setServiceId(id);
        ServiceDto updateService = servicesService.updateService(id, service);
        ServiceResponse response = modelMapper.map(updateService, ServiceResponse.class);
        return new ResponseEntity<ServiceResponse>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteService(@PathVariable Long id){
        servicesService.deleteService(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
