package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.LigneCommDto;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.LignCmdNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;
import mr.fssm.invoicesspringboot.request.LigneCmdRequest;
import mr.fssm.invoicesspringboot.response.LignCmdResponse;
import mr.fssm.invoicesspringboot.service.LigneCmdService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ligneCmd")
@RequiredArgsConstructor
public class LigneCmdController {
    private final ModelMapper modelMapper = new ModelMapper();
    private final LigneCmdService ligneCmdService;
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<LignCmdResponse> saveLigneCmd (@RequestBody @Valid LigneCmdRequest request) throws InvoiceNotFoundException, ProductNotFoundException {
        LigneCommDto ligneCommDto= modelMapper.map(request, LigneCommDto.class);
        LigneCommDto createLignCmd = ligneCmdService.createLignCmd(ligneCommDto);
        LignCmdResponse response = modelMapper.map(createLignCmd, LignCmdResponse.class);
        return new ResponseEntity<LignCmdResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LignCmdResponse> getLigneCmd(@PathVariable (name = "id") String id) throws LignCmdNotFoundException {
        LigneCommDto ligneCommDto = ligneCmdService.getLignCmd(id);
        LignCmdResponse response = modelMapper.map(ligneCommDto, LignCmdResponse.class);
        return new ResponseEntity<LignCmdResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<LignCmdResponse> listLignCmd()  {
        List<LigneCommDto> ligneCommDtos = ligneCmdService.listLignCmd();
        List<LignCmdResponse> responses = ligneCommDtos.stream()
                .map(ligneCmd -> modelMapper.map(ligneCmd, LignCmdResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<LignCmdResponse> updateLignCmd(@PathVariable String id, @RequestBody LigneCommDto ligneCommDto) throws LignCmdNotFoundException {
        ligneCommDto.setId(id);
        LigneCommDto updateLignCmd = ligneCmdService.updateLignCmd(id, ligneCommDto);
        LignCmdResponse response = modelMapper.map(updateLignCmd, LignCmdResponse.class);
        return new ResponseEntity<LignCmdResponse>(response, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteLignCmd(@PathVariable String id){
        ligneCmdService.deleteLigneCmd(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
