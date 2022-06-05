package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.ClientDto;
import mr.fssm.invoicesspringboot.Dto.FournisseurDto;
import mr.fssm.invoicesspringboot.exceptions.ClientNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.request.ClientRequest;
import mr.fssm.invoicesspringboot.request.FournisseurRequest;
import mr.fssm.invoicesspringboot.response.ClientResponse;
import mr.fssm.invoicesspringboot.response.FournisseurResponse;

import java.util.List;


public interface PersonneService {


    ClientDto createCli(ClientDto client) throws CompanyNotFoundException;
    FournisseurDto createFourni(FournisseurDto userDto) throws CompanyNotFoundException;

    ClientDto getClient(String clientId) throws ClientNotFoundException;

    FournisseurDto getFourni(String FourniId) throws FournisseurNotFoundException;

    List<ClientDto> listClients();

    List<FournisseurDto> listFournis();

    ClientDto updateClient(String id, ClientDto clientDto) throws ClientNotFoundException;
    FournisseurDto updateFourni(String id, FournisseurDto fournisseurDto) throws FournisseurNotFoundException;
}
