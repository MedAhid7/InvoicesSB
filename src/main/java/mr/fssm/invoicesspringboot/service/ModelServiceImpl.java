package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.ModelDto;
import mr.fssm.invoicesspringboot.Mapper.ModelMepperImpl;
import mr.fssm.invoicesspringboot.entities.Company;
import mr.fssm.invoicesspringboot.entities.Modele;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ModelNontFoundException;
import mr.fssm.invoicesspringboot.exceptions.ModelNotFoundException;
import mr.fssm.invoicesspringboot.repository.CompanyRepo;
import mr.fssm.invoicesspringboot.repository.ModelRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ModelServiceImpl implements ModelService {
    private final ModelMepperImpl dtoMapper;
    private final ModelRepo modelRepo;
    private final CompanyRepo companyRepo;
    @Override
    public ModelDto createModel(ModelDto modelDto) throws ModelNontFoundException {
        log.info("saving new Model");
        Company company = companyRepo.findById(modelDto.getCompany().getCompanyId()).orElse(null);
        if (company == null){
            throw new ModelNontFoundException("Company not found");
        }
        Modele modele = dtoMapper.fromModelDTO(modelDto);

        modele.setModelId(UUID.randomUUID().toString());
        modele.setCompany(company);
        Modele newModel = modelRepo.save(modele);
        ModelDto savedModel = dtoMapper.fromModel(newModel);
        return savedModel;
    }
    @Override
    public ModelDto getModel(String id) throws CompanyNotFoundException, ModelNotFoundException {
        Modele modele = modelRepo.findById(id)
                .orElseThrow(()->new ModelNotFoundException("Model not found"));
        return dtoMapper.fromModel(modele);
    }
    @Override
    public List<ModelDto> listModels() {
        List <Modele> modeles = modelRepo.findAll();
        List <ModelDto> modelDtos = modeles.stream()
                .map(model -> dtoMapper.fromModel(model))
                .collect(Collectors.toList());
        return modelDtos;
    }

}
