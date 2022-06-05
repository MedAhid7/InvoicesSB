package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.ClientDto;
import mr.fssm.invoicesspringboot.Dto.FournisseurDto;
import mr.fssm.invoicesspringboot.Mapper.PersonneMapperImpl;
import mr.fssm.invoicesspringboot.entities.*;
import mr.fssm.invoicesspringboot.exceptions.ClientNontFoundException;
import mr.fssm.invoicesspringboot.exceptions.ClientNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.repository.*;
import mr.fssm.invoicesspringboot.request.FournisseurRequest;
import mr.fssm.invoicesspringboot.response.ClientResponse;
import mr.fssm.invoicesspringboot.response.FournisseurResponse;
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
public class PersonneServiceImpl implements PersonneService {
    private final ClientRepo clientRepo;
    private final FournisseurRepo fournisseurRepo;
    private final PersonneMapperImpl dtoMapper;
    private final CompanyRepo companyRepo;

    @Override
    public ClientDto createCli(ClientDto client) throws CompanyNotFoundException {
        log.info("Saving new Client");
        Company company = companyRepo.findById(client.getCompany().getCompanyId()).orElse(null);
        if (company == null){
            throw new CompanyNotFoundException("Company not found");
        }
        client.getLogo().setUser(client);
        client.getAddress().setUser(client);
        ModelMapper modelMapper = new ModelMapper();
        Client personne = modelMapper.map(client, Client.class);
        personne.setUserId(UUID.randomUUID().toString());
        personne.setCompany(company);

        Client newPersonne = clientRepo.save(personne);
        ClientDto savedClient= modelMapper.map(newPersonne, ClientDto.class);
        return savedClient;
    }
    @Override
    public ClientDto getClient(String clientId) throws ClientNotFoundException {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(()->new ClientNotFoundException("Client not found"));
        return dtoMapper.fromClient(client);
    }
    @Override
    public List<ClientDto> listClients() {
        List <Client> clients = clientRepo.findAll();
        List <ClientDto> clientDtos = clients.stream()
                .map(client -> dtoMapper.fromClient(client))
                .collect(Collectors.toList());
        return clientDtos;
    }
    @Override
    public ClientDto updateClient(String id, ClientDto clientDto) throws ClientNotFoundException {
        log.info("saving new client");
        Client client = clientRepo.findById(id)
                .orElseThrow(()->new ClientNotFoundException("Client not found"));
        Company company = companyRepo.findById(clientDto.getCompany().getCompanyId()).orElse(null);
        client.setCompany(company);
        client = dtoMapper.fromClientDTO(clientDto);
        Client savedClient = clientRepo.save(client);
        return dtoMapper.fromClient(savedClient);
    }
    @Override
    public FournisseurDto createFourni(FournisseurDto userDto) throws CompanyNotFoundException {
        log.info("Saving new Fournisseur");
        Company company = companyRepo.findById(userDto.getCompany().getCompanyId()).orElse(null);
        if (company == null){
            throw new CompanyNotFoundException("Company not found");
        }

        userDto.getAddress().setUser(userDto);

        Fournisseur user = dtoMapper.fromFourniDTO(userDto);
        user.setUserId(UUID.randomUUID().toString());
        user.setCompany(company);


        Fournisseur createUser = fournisseurRepo.save(user);
        FournisseurDto savedUser = dtoMapper.fromFourni(createUser);
        return savedUser;
    }
     @Override
    public FournisseurDto getFourni(String id) throws FournisseurNotFoundException {
        Fournisseur user = fournisseurRepo.findById(id)
                .orElseThrow(()->new FournisseurNotFoundException("User not found"));
        return dtoMapper.fromFourni(user);
    }
    @Override
    public List<FournisseurDto> listFournis() {
        List <Fournisseur> fournisseurs = fournisseurRepo.findAll();
        List <FournisseurDto> fournisseurDtos = fournisseurs.stream()
                .map(fournisseur -> dtoMapper.fromFourni(fournisseur))
                .collect(Collectors.toList());
        return fournisseurDtos;
    }
    @Override
    public FournisseurDto updateFourni(String id, FournisseurDto fournisseurDto) throws FournisseurNotFoundException {
        log.info("update User");
        Fournisseur fournisseur = fournisseurRepo.findById(id)
                .orElseThrow(()->new FournisseurNotFoundException("User not found"));
        Company company = companyRepo.findById(fournisseurDto.getCompany().getCompanyId()).orElse(null);
        fournisseur.setCompany(company);
        fournisseur = dtoMapper.fromFourniDTO(fournisseurDto);
        Fournisseur savedFourni = fournisseurRepo.save(fournisseur);
        return dtoMapper.fromFourni(savedFourni);
    }
}
