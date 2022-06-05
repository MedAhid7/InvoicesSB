package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.AcompteDto;
import mr.fssm.invoicesspringboot.exceptions.AcompteNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;

import java.util.List;

public interface AcompteService {
    AcompteDto createAcompte(AcompteDto acompteDto) throws InvoiceNotFoundException;

    AcompteDto getAcompte(Long id) throws AcompteNotFoundException;

    List<AcompteDto> listAcompte();

    AcompteDto updateAcompte(Long id, AcompteDto acompteDto) throws AcompteNotFoundException;
}
