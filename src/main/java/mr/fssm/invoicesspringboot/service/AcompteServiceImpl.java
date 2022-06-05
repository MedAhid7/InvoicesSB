package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.AcompteDto;
import mr.fssm.invoicesspringboot.entities.Acompte;
import mr.fssm.invoicesspringboot.entities.Invoice;
import mr.fssm.invoicesspringboot.exceptions.AcompteNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.repository.AcompteRepo;
import mr.fssm.invoicesspringboot.repository.InvoiceRepo;
import org.modelmapper.ModelMapper;
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
    private final AcompteRepo acompteRepo;
    private final InvoiceRepo invoiceRepo;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public AcompteDto createAcompte(AcompteDto acompteDto) throws InvoiceNotFoundException {
        log.info("Saving new Acompte");
        Invoice invoice = invoiceRepo.findByCodeInvoice(acompteDto.getInvoice().getCodeInvoice());
        if (invoice == null){
            throw new InvoiceNotFoundException("Invoice not found");
        }
        Acompte acompte = modelMapper.map(acompteDto, Acompte.class);
        acompte.setInvoice(invoice);
        acompte.setDatePays(new Date());

        Acompte newAcompte = acompteRepo.save(acompte);
        AcompteDto savedAcompte= modelMapper.map(newAcompte, AcompteDto.class);
        return savedAcompte;
    }
    @Override
    public AcompteDto getAcompte(Long id) throws AcompteNotFoundException {
        Acompte acompte = acompteRepo.findById(id)
                .orElseThrow(()->new AcompteNotFoundException("Acompte not found"));
        return modelMapper.map(acompte, AcompteDto.class);
    }
    @Override
    public List<AcompteDto> listAcompte() {
        List <Acompte> acomptes = acompteRepo.findAll();
        List <AcompteDto> acompteDtos = acomptes.stream()
                .map(acompte -> modelMapper.map(acompte, AcompteDto.class))
                .collect(Collectors.toList());
        return acompteDtos;
    }
    @Override
    public AcompteDto updateAcompte(Long id, AcompteDto acompteDto) throws AcompteNotFoundException {
        log.info("update Acompte");
        Acompte acompte = acompteRepo.findById(id)
                .orElseThrow(()->new AcompteNotFoundException("Reglement not found"));
        Invoice invoice = invoiceRepo.findByCodeInvoice(acompteDto.getInvoice().getCodeInvoice());
        acompte.setInvoice(invoice);
        acompte = modelMapper.map(acompteDto, Acompte.class);
        Acompte savedAcompte = acompteRepo.save(acompte);
        return modelMapper.map(savedAcompte, AcompteDto.class);
    }
}
