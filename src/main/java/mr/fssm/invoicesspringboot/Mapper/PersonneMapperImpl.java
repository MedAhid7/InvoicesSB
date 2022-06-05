package mr.fssm.invoicesspringboot.Mapper;

import mr.fssm.invoicesspringboot.Dto.ClientDto;
import mr.fssm.invoicesspringboot.Dto.FournisseurDto;
import mr.fssm.invoicesspringboot.entities.Client;
import mr.fssm.invoicesspringboot.entities.Fournisseur;
import mr.fssm.invoicesspringboot.request.FournisseurRequest;
import mr.fssm.invoicesspringboot.response.ClientResponse;
import mr.fssm.invoicesspringboot.response.FournisseurResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonneMapperImpl {
    ModelMapper modelMapper = new ModelMapper();
    public Client fromClientDTO(ClientDto clientDto){
        Client client = modelMapper.map(clientDto, Client.class);
        return client;
    }
    public ClientDto fromClient(Client client){
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }
    public ClientResponse fromClientToResponse(Client client){
        ClientResponse response = modelMapper.map(client, ClientResponse.class);
        return response;
    }
    public ClientResponse fromDtoToResponse(ClientDto client){
        ClientResponse response = modelMapper.map(client, ClientResponse.class);
        return response;
    }
    public Fournisseur fromFourniDTO(FournisseurDto fournisseurDto){
        Fournisseur fournisseur = modelMapper.map(fournisseurDto, Fournisseur.class);
        return fournisseur;
    }
    public FournisseurDto fromFourni(Fournisseur fournisseur){
        FournisseurDto fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
        return fournisseurDto;
    }
    public FournisseurDto fromRequestToDto(FournisseurRequest request){
        FournisseurDto user = modelMapper.map(request, FournisseurDto.class);
        return user;
    }
    public FournisseurResponse fromDtoToResponse(FournisseurDto user){
        FournisseurResponse response = modelMapper.map(user, FournisseurResponse.class);
        return response;
    }
}
