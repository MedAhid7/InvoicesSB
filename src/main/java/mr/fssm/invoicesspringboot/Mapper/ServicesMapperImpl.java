package mr.fssm.invoicesspringboot.Mapper;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.Dto.ServiceDto;
import mr.fssm.invoicesspringboot.entities.Produit;
import mr.fssm.invoicesspringboot.entities.Services;
import mr.fssm.invoicesspringboot.request.AcompteRequest;
import mr.fssm.invoicesspringboot.request.ServiceRequest;
import mr.fssm.invoicesspringboot.response.ProduitsResponse;
import mr.fssm.invoicesspringboot.response.ServiceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ServicesMapperImpl {
    private final ModelMapper dtoMapper=new ModelMapper();

    public Services fromServiceDto(ServiceDto service){
        return dtoMapper.map(service, Services.class);
    }
    public ServiceDto fromService(Services service){
        return dtoMapper.map(service, ServiceDto.class);
    }
    public ServiceResponse fromDtoToResponse(ServiceDto service){
        return dtoMapper.map(service, ServiceResponse.class);
    }
    public ServiceDto fromRequestToDto(ServiceRequest request){
        return dtoMapper.map(request, ServiceDto.class);
    }
}
