package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;
import mr.fssm.invoicesspringboot.Mapper.AcompteMapperImpl;

import mr.fssm.invoicesspringboot.entities.Acompte;
import mr.fssm.invoicesspringboot.entities.Invoice;
import mr.fssm.invoicesspringboot.exceptions.AcompteNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.repository.AcompteRepo;
import mr.fssm.invoicesspringboot.repository.InvoiceRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AcompteServiceImpl implements AcompteService {
    private final AcompteMapperImpl dtoMapper;
    private final AcompteRepo acompteRepo;
    private final InvoiceRepo invoiceRepo;

    @Override
    public AcompteDto createAcompte(AcompteDto acompteDto) throws InvoiceNotFoundException {

        Invoice invoice = invoiceRepo.findByCodeInvoice(acompteDto.getInvoice().getCodeInvoice());
        if (invoice == null){
            throw new InvoiceNotFoundException("Invoice not found");
        }
        Acompte acompte = dtoMapper.fromAcompteDto(acompteDto);
        acompte.setInvoice(invoice);
        acompte.setDatePays(new Date());

        Acompte newAcompte = acompteRepo.save(acompte);
        log.info("Saving new Acompte");
        return dtoMapper.fromAcompte(newAcompte);
    }
    @Override
    public AcompteDto getAcompte(Long id) throws AcompteNotFoundException {
        Acompte acompte = acompteRepo.findById(id)
                .orElseThrow(()->new AcompteNotFoundException("Acompte not found"));
        return dtoMapper.fromAcompte(acompte);
    }
    @Override
    public List<AcompteDto> listAcompte() {
        List <Acompte> acomptes = acompteRepo.findAll();
        return acomptes.stream()
                .map(dtoMapper::fromAcompte)
                .collect(Collectors.toList());
    }
    @Override
    public AcompteDto updateAcompte(Long id, AcompteDto acompteDto) throws AcompteNotFoundException {
        log.info("update Acompte");
        Acompte acompte = acompteRepo.findById(id)
                .orElseThrow(()->new AcompteNotFoundException("Reglement not found"));
        Invoice invoice = invoiceRepo.findByCodeInvoice(acompteDto.getInvoice().getCodeInvoice());
        acompte.setInvoice(invoice);
        Acompte savedAcompte = acompteRepo.save(acompte);
        return dtoMapper.fromAcompte(savedAcompte);
    }
}
