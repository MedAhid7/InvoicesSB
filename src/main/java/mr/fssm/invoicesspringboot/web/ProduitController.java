package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.Dto.FournisseurDto;
import mr.fssm.invoicesspringboot.Dto.ProduitDto;
import mr.fssm.invoicesspringboot.Dto.ReglementDto;
import mr.fssm.invoicesspringboot.exceptions.FournisseurNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.InvoiceNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;
import mr.fssm.invoicesspringboot.exceptions.ReglementNotFoundException;
import mr.fssm.invoicesspringboot.request.ProduitRequest;
import mr.fssm.invoicesspringboot.request.ReglementRequest;
import mr.fssm.invoicesspringboot.response.FournisseurResponse;
import mr.fssm.invoicesspringboot.response.ProduitsResponse;
import mr.fssm.invoicesspringboot.response.ReglementResponse;
import mr.fssm.invoicesspringboot.service.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;
    private final ModelMapper modelMapper = new ModelMapper();
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProduitsResponse> saveProduct (@RequestBody @Valid ProduitRequest request) throws FournisseurNotFoundException {
        ProduitDto produit= modelMapper.map(request, ProduitDto.class);
        ProduitDto createProduit = produitService.createProduct(produit);
        ProduitsResponse response = modelMapper.map(createProduit, ProduitsResponse.class);
        return new ResponseEntity<ProduitsResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProduitsResponse> getProduct(@PathVariable (name = "id") Long id) throws ProductNotFoundException {
        ProduitDto product = produitService.getProduct(id);
        ProduitsResponse response = modelMapper.map(product, ProduitsResponse.class);
        return new ResponseEntity<ProduitsResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<ProduitsResponse> listProducts()  {
        List<ProduitDto> productDtos = produitService.listProducts();
        List<ProduitsResponse> responses = productDtos.stream()
                .map(product -> modelMapper.map(product, ProduitsResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProduitsResponse> updateProduct(@PathVariable Long id, @RequestBody ProduitDto product) throws ProductNotFoundException {
        product.setProductId(id);
        ProduitDto updateProduct = produitService.updateProduct(id, product);
        ProduitsResponse response = modelMapper.map(updateProduct, ProduitsResponse.class);
        return new ResponseEntity<ProduitsResponse>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        produitService.deleteProduit(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
