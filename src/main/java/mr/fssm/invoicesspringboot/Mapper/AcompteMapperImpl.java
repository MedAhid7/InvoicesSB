package mr.fssm.invoicesspringboot.Mapper;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;

import mr.fssm.invoicesspringboot.entities.Acompte;

import mr.fssm.invoicesspringboot.request.AcompteRequest;

import mr.fssm.invoicesspringboot.response.AcompteResponse;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AcompteMapperImpl {
    private final ModelMapper dtoMapper=new ModelMapper();

    public Acompte fromAcompteDto(AcompteDto acompteDto){
        return dtoMapper.map(acompteDto, Acompte.class);
    }
    public AcompteDto fromAcompte(Acompte acompte){
        return dtoMapper.map(acompte, AcompteDto.class);
    }
    public AcompteResponse fromDtoToResponse(AcompteDto acompte){
        return dtoMapper.map(acompte, AcompteResponse.class);
    }
    public AcompteDto fromRequestToDto(AcompteRequest request){
        return dtoMapper.map(request, AcompteDto.class);
    }
}
