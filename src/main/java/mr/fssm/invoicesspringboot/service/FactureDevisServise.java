package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.DevisDto;
import mr.fssm.invoicesspringboot.Dto.InvoiceDto;
import mr.fssm.invoicesspringboot.exceptions.*;

import java.util.List;

public interface FactureDevisServise {
   /* Facture saveFacture(Facture facture);
 Devis loadDevisById(int idDevis);
 Devis saveDevis(Devis devis);
 List<Devis> getDevis(int page, int limit);
    */
  /* @Override
        public List<Facture> getFactures(int page, int limit) {
            List<Facture> factures = new ArrayList<>();
            Pageable pageableRequest = PageRequest.of(page, limit);
            Page<Facture> facturePage = factureDevisRepo.findAll(pageableRequest);
            List<Facture> facs =facturePage.getContent();
            for (Facture facture : facs){
                Facture fac = new Facture();
                BeanUtils.copyProperties(facture,fac);
                factures.add(fac);
            }
            return factures;
        }
    */

  /* @Override
        public List<Facture> getFactures(int page, int limit) {
            List<Facture> factures = new ArrayList<>();
            Pageable pageableRequest = PageRequest.of(page, limit);
            Page<Facture> facturePage = factureDevisRepo.findAll(pageableRequest);
            List<Facture> facs =facturePage.getContent();
            for (Facture facture : facs){
                Facture fac = new Facture();
                BeanUtils.copyProperties(facture,fac);
                factures.add(fac);
            }
            return factures;
        }

    */
        //Ctree Facture
    InvoiceDto createInvoice(InvoiceDto invoiceDto) throws ClientNontFoundException, DevisNontFoundException;

    //  FactureResponse createFacture(FactureRequest factureRequest) throws ClientNontFoundException;
    DevisDto createDevis(DevisDto devisDto) throws InvoiceNotFoundException, ClientNontFoundException;
    InvoiceDto getInvoice(String factureId) throws InvoiceNotFoundException;
    DevisDto getDevis(String devisId) throws DevisNotFoundException;
    List<InvoiceDto> listInvoices();
    List<DevisDto> listDevis();
    DevisDto updateDevis(Long id, DevisDto devisDto) throws DevisNotFoundException;
    InvoiceDto updateInvoice(Long id, InvoiceDto invoiceDto) throws InvoiceNotFoundException, DevisNontFoundException;
  //  void deleteDevis(String devisId);
    void addModelToInvoice(String modelId, String invoiceId) throws ModelNontFoundException, InvoiceNotFoundException;
    void addModelToDevis(String modelId, String devisId) throws ModelNontFoundException, DevisNontFoundException;

}
