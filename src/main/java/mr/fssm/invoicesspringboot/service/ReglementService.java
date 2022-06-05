package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.ReglementDto;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ReglementNotFoundException;

import java.util.List;

public interface ReglementService {
    ReglementDto createReglement(ReglementDto reglementDto) throws InvoiceNotFoundException;

    ReglementDto getReglement(Long id) throws ReglementNotFoundException;

    List<ReglementDto> listReglements();

    ReglementDto updateReglement(Long id, ReglementDto reglementDto) throws ReglementNotFoundException;

    void deleteDReglement(Long id);
}
