package mr.fssm.invoicesspringboot.Mapper;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.Dto.ReglementDto;
import mr.fssm.invoicesspringboot.entities.Produit;
import mr.fssm.invoicesspringboot.entities.Reglement;
import mr.fssm.invoicesspringboot.request.AcompteRequest;
import mr.fssm.invoicesspringboot.request.ReglementRequest;
import mr.fssm.invoicesspringboot.response.ProduitsResponse;
import mr.fssm.invoicesspringboot.response.ReglementResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ReglementMapperImpl {
    private final ModelMapper dtoMapper=new ModelMapper();

    public Reglement fromReglementDto(ReglementDto reglement){
        return dtoMapper.map(reglement, Reglement.class);
    }
    public ReglementDto fromProduct(Reglement reglement){
        return dtoMapper.map(reglement, ReglementDto.class);
    }
    public ReglementResponse fromDtoToResponse(ReglementDto reglement){
        return dtoMapper.map(reglement, ReglementResponse.class);
    }
    public ReglementDto fromRequestToDto(ReglementRequest request){
        return dtoMapper.map(request, ReglementDto.class);
    }
}
