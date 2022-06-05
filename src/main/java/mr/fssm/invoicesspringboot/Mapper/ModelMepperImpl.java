package mr.fssm.invoicesspringboot.Mapper;

import mr.fssm.invoicesspringboot.Dto.ModelDto;
import mr.fssm.invoicesspringboot.entities.Modele;
import mr.fssm.invoicesspringboot.request.ModelRequest;
import mr.fssm.invoicesspringboot.response.ModelResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ModelMepperImpl {
    ModelMapper dtoMapper=new ModelMapper();
    public Modele fromModelDTO(ModelDto modelDto){
        Modele modele =dtoMapper.map(modelDto, Modele.class);
        return modele;
    }
    public ModelDto fromModel(Modele modele){
        ModelDto modelDto=dtoMapper.map(modele, ModelDto.class);
        return modelDto;
    }
    public ModelResponse fromModelDtoToResponse(ModelDto modelDto){
        ModelResponse modelResponse =dtoMapper.map(modelDto, ModelResponse.class);
        return modelResponse;
    }
    public ModelDto fromModelRequestToDTO(ModelRequest modelRequest){
        ModelDto modelDto =dtoMapper.map(modelRequest, ModelDto.class);
        return modelDto;
    }
}
