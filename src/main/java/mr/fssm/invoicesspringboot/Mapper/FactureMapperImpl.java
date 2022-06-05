package mr.fssm.invoicesspringboot.Mapper;

import mr.fssm.invoicesspringboot.Dto.DevisDto;
import mr.fssm.invoicesspringboot.Dto.InvoiceDto;
import mr.fssm.invoicesspringboot.entities.Devis;
import mr.fssm.invoicesspringboot.entities.Invoice;
import mr.fssm.invoicesspringboot.request.DevisRequest;
import mr.fssm.invoicesspringboot.request.InvoiceRequest;
import mr.fssm.invoicesspringboot.response.DevisResponse;
import mr.fssm.invoicesspringboot.response.InvoiceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FactureMapperImpl {
    ModelMapper dtoMapper=new ModelMapper();
    public DevisDto fromDevis(Devis devis){
        DevisDto devisDto = dtoMapper.map(devis, DevisDto.class);
        return devisDto;
    }
    public Devis fromDevisDTO(DevisDto devisDto){
        Devis devis = dtoMapper.map(devisDto, Devis.class);
        return devis;
    }
    public DevisDto fromDevisRequesttoDto(DevisRequest devis){
        DevisDto devisDto = dtoMapper.map(devis, DevisDto.class);
        return devisDto;
    }
    public DevisResponse fromDevisDtoToResponse(DevisDto devisDto){
        DevisResponse devis = dtoMapper.map(devisDto, DevisResponse.class);
        return devis;
    }
    public InvoiceDto fromInvoice(Invoice invoice){
        InvoiceDto invoiceDto = dtoMapper.map(invoice, InvoiceDto.class);
        return invoiceDto;
    }
    public Invoice fromInvoiceDTO(InvoiceDto invoiceDto){

        Invoice invoice = dtoMapper.map(invoiceDto, Invoice.class);
        return invoice;
    }
    public InvoiceResponse fromDtoToResponse(InvoiceDto invoice){
        InvoiceResponse response = dtoMapper.map(invoice, InvoiceResponse.class);
        return response;
    }
    public InvoiceDto fromRequestToDto(InvoiceRequest request){
        InvoiceDto invoice = dtoMapper.map(request, InvoiceDto.class);
        return invoice;
    }
}
