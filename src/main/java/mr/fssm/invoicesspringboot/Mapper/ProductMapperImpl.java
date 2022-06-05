package mr.fssm.invoicesspringboot.Mapper;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;
import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.entities.Acompte;
import mr.fssm.invoicesspringboot.entities.Produit;
import mr.fssm.invoicesspringboot.request.AcompteRequest;
import mr.fssm.invoicesspringboot.request.ProduitRequest;
import mr.fssm.invoicesspringboot.response.AcompteResponse;
import mr.fssm.invoicesspringboot.response.ProduitsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ProductMapperImpl {
    private final ModelMapper dtoMapper=new ModelMapper();

    public Produit fromProductDto(ProduitDto product){
        return dtoMapper.map(product, Produit.class);
    }
    public ProduitDto fromProduct(Produit product){
        return dtoMapper.map(product, ProduitDto.class);
    }
    public ProduitsResponse fromDtoToResponse(ProduitDto product){
        return dtoMapper.map(product, ProduitsResponse.class);
    }
    public ProduitDto fromRequestToDto(ProduitRequest request){
        return dtoMapper.map(request, ProduitDto.class);
    }
}
