package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.*;
import mr.fssm.invoicesspringboot.Mapper.PersonneMapperImpl;
import mr.fssm.invoicesspringboot.exceptions.ClientNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.request.ClientRequest;
import mr.fssm.invoicesspringboot.request.FournisseurRequest;
import mr.fssm.invoicesspringboot.response.*;
import mr.fssm.invoicesspringboot.service.PersonneService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class PersonneController {
    private final PersonneService personneService;
    private final PersonneMapperImpl dtoMapper;
    @PostMapping(value = "/client/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ClientResponse> createClient (@RequestBody @Valid ClientRequest clientRequest) throws CompanyNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        ClientDto clientDto = modelMapper.map(clientRequest, ClientDto.class);
        ClientDto createClient = personneService.createCli(clientDto);
        ClientResponse savedClient = modelMapper.map(createClient, ClientResponse.class);
        return new ResponseEntity<ClientResponse>(savedClient, HttpStatus.CREATED) ;
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable (name = "id") String clientId) throws ClientNotFoundException {
        ClientDto client = personneService.getClient(clientId);
        ClientResponse response = dtoMapper.fromDtoToResponse(client);
        return new ResponseEntity<ClientResponse>(response, HttpStatus.OK) ;

    }
    @GetMapping("/clients")
    public List<ClientResponse> listCustomer()  {
        List <ClientDto> clients = personneService.listClients();
        List <ClientResponse> responses = clients.stream()
                .map(client -> dtoMapper.fromDtoToResponse(client))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/client/update/{clientId}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable String clientId, @RequestBody ClientDto client) throws ClientNotFoundException {
        client.setUserId(clientId);
        ClientDto createClient =  personneService.updateClient(clientId, client);
        ClientResponse savedClient = dtoMapper.fromDtoToResponse(createClient);
        return new ResponseEntity<ClientResponse>(savedClient, HttpStatus.ACCEPTED) ;
    }
    @PostMapping("/fournisseur/create")
    public ResponseEntity<FournisseurResponse> createFour (@RequestBody FournisseurRequest request) throws CompanyNotFoundException {
        FournisseurDto fournisseurDto= dtoMapper.fromRequestToDto(request);
        FournisseurDto createUser = personneService.createFourni(fournisseurDto);
        FournisseurResponse savedUser = dtoMapper.fromDtoToResponse(createUser);
        return new ResponseEntity<FournisseurResponse>(savedUser, HttpStatus.CREATED) ;
    }
    @GetMapping("/fournisseur/{id}")
    public ResponseEntity<FournisseurResponse> getFourni(@PathVariable (name = "id") String fourniId) throws FournisseurNotFoundException {
        FournisseurDto user = personneService.getFourni(fourniId);
        FournisseurResponse response = dtoMapper.fromDtoToResponse(user);
        return new ResponseEntity<FournisseurResponse>(response, HttpStatus.OK) ;
    }

    @GetMapping("/fournisseurs")
    public List<FournisseurResponse> listFournis()  {
        List <FournisseurDto> users = personneService.listFournis();
        List <FournisseurResponse> responses = users.stream()
                .map(user -> dtoMapper.fromDtoToResponse(user))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/fournisseur/update/{id}")
    public ResponseEntity<FournisseurResponse> updateFourni(@PathVariable String id, @RequestBody FournisseurDto fournisseurDto) throws FournisseurNotFoundException {
        fournisseurDto.setUserId(id);
        FournisseurDto updateUser = personneService.updateFourni(id, fournisseurDto);
        FournisseurResponse savedUser = dtoMapper.fromDtoToResponse(updateUser);
        return new ResponseEntity<FournisseurResponse>(savedUser, HttpStatus.ACCEPTED) ;
    }
}
