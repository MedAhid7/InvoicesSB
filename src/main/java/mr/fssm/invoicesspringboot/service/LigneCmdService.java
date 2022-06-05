package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.LigneCommDto;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.LignCmdNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;

import java.util.List;

public interface LigneCmdService {
    LigneCommDto createLignCmd(LigneCommDto ligneCommDto) throws InvoiceNotFoundException, ProductNotFoundException;

    LigneCommDto getLignCmd(String id) throws LignCmdNotFoundException;

    List<LigneCommDto> listLignCmd();

    LigneCommDto updateLignCmd(String id, LigneCommDto ligneCommDto) throws LignCmdNotFoundException;

    void deleteLigneCmd(String id);
}
