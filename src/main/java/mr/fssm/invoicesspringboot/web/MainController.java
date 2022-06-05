package mr.fssm.invoicesspringboot.web;

import lombok.RequiredArgsConstructor;
import mr.fssm.invoicesspringboot.entities.Personne;
import mr.fssm.invoicesspringboot.service.FactureDevisServise;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users/")
public class MainController {
    private FactureDevisServise factureDevisServise;

    /*@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<FactureResponse> getAllFacture(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit){
        List<FactureResponse> facturesResp = new ArrayList<>();
        List<Facture> fac = factureDevisServise.getFactures(page, limit);
        for (Facture facture : fac){
            FactureResponse facRes = new FactureResponse();
            BeanUtils.copyProperties(facture,facRes);
            facturesResp.add(facRes);
        }
        return  facturesResp;
    }
    @PostMapping
    public PersonneResponse createUser(@RequestBody Personne personne){
        return  null;
    }*/
    @PutMapping
    public String updateUser(){
        return  "update user was called";
    }
    @DeleteMapping
    public String deleteUser(){
        return  "delete user was called";
    }


/*
    @PostMapping("/fac1/save")
    public FactureResponse createUser(@RequestBody Facture facture){
        //couche Presentation
        Facture fac = new Facture();
        BeanUtils.copyProperties(facture, fac);
        //couche Service
        Facture createUser = factureDevisServise.saveFacture(fac);
        //Couche Data
        FactureResponse facResponse = new FactureResponse();
        BeanUtils.copyProperties(createUser, facResponse);
        return facResponse;
    }
    @PostMapping("/fac2/save")
    public ResponseEntity<Facture> saveRole(@RequestBody Facture role){
        return ResponseEntity.ok().body(factureDevisServise.saveFacture(role));
    }
*/


}
