package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.ModelDto;
import mr.fssm.invoicesspringboot.exceptions.CompanyNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ModelNontFoundException;
import mr.fssm.invoicesspringboot.exceptions.ModelNotFoundException;

import java.util.List;

public interface ModelService {
    ModelDto createModel(ModelDto modelDto) throws ModelNontFoundException;

    ModelDto getModel(String id) throws CompanyNotFoundException, ModelNotFoundException;

    List<ModelDto> listModels();
}
