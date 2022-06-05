package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.DevisDto;
import mr.fssm.invoicesspringboot.Dto.ModelDto;
import mr.fssm.invoicesspringboot.Mapper.ModelMepperImpl;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.DevisNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ModelNontFoundException;
import mr.fssm.invoicesspringboot.exceptions.ModelNotFoundException;
import mr.fssm.invoicesspringboot.request.ModelRequest;
import mr.fssm.invoicesspringboot.response.CompanyResponse;
import mr.fssm.invoicesspringboot.response.DevisResponse;
import mr.fssm.invoicesspringboot.response.ModelResponse;
import mr.fssm.invoicesspringboot.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/model")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;
    private final ModelMepperImpl dtoMapper;
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ModelResponse> saveModel (@RequestBody @Valid ModelRequest modelRequest) throws ModelNontFoundException {
        ModelDto modele = dtoMapper.fromModelRequestToDTO(modelRequest);
        ModelDto createModel = modelService.createModel(modele);
        ModelResponse modelResponse = dtoMapper.fromModelDtoToResponse(createModel);
        return new ResponseEntity<ModelResponse>(modelResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModelResponse> getModel(@PathVariable (name = "id") String id) throws CompanyNotFoundException, DevisNotFoundException, ModelNotFoundException {
        ModelDto model = modelService.getModel(id);
        ModelResponse response = dtoMapper.fromModelDtoToResponse(model);
        return new ResponseEntity<ModelResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<ModelResponse> listCompanies()  {
        List<ModelDto> models = modelService.listModels();
        List<ModelResponse> responses = models.stream()
                .map(model -> dtoMapper.fromModelDtoToResponse(model))
                .collect(Collectors.toList());
        return responses;
    }

}
