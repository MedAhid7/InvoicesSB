package mr.fssm.invoicesspringboot.Mapper;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;
import mr.fssm.invoicesspringboot.Dto.LigneCommDto;
import mr.fssm.invoicesspringboot.entities.Acompte;
import mr.fssm.invoicesspringboot.entities.LigneCommandes;
import mr.fssm.invoicesspringboot.request.AcompteRequest;
import mr.fssm.invoicesspringboot.request.LigneCmdRequest;
import mr.fssm.invoicesspringboot.response.AcompteResponse;
import mr.fssm.invoicesspringboot.response.LignCmdResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class LignCmdMapperImpl {
    private final ModelMapper dtoMapper=new ModelMapper();

    public LigneCommandes fromLignCmdDto(LigneCommDto lignCmd){
        return dtoMapper.map(lignCmd, LigneCommandes.class);
    }
    public LigneCommDto fromLignCmd(LigneCommandes lignCmd){
        return dtoMapper.map(lignCmd, LigneCommDto.class);
    }
    public LignCmdResponse fromDtoToResponse(LigneCommDto lignCmd){
        return dtoMapper.map(lignCmd, LignCmdResponse.class);
    }
    public LigneCommDto fromRequestToDto(LigneCmdRequest request){
        return dtoMapper.map(request, LigneCommDto.class);
    }
}
