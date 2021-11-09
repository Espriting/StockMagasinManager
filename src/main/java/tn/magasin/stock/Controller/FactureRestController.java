package tn.magasin.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.entity.Facture;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
    @Autowired
    IFactureService factureService;
    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<Facture> getFactures(){
        List<Facture> listFactures = factureService.retrieveALLFactures();
        return listFactures;
    }
    @GetMapping("/retrieve-facture/{facture-id}")
    @ResponseBody
    public Optional<Facture> retrieveFacture(@PathVariable("facture-id") Long idFacture) {
        return factureService.retrieveFacture(idFacture);
    }
    @PostMapping("/add-facture")
    @ResponseBody
    public Facture addClient(@RequestBody Facture f) {
        Facture facture = factureService.addFacture(f);
        return facture;
    }
    @DeleteMapping("/remove-facture/{facture-id}")
    @ResponseBody
    public void removeFacture(@PathVariable("facture-id") Long factureId) {
        factureService.deleteFactureById(factureId);
    }
    @PutMapping("/modify-facture")
    @ResponseBody
    public Facture modifyFacture(@RequestBody Facture facture) {
        return factureService.updateFacture(facture);
    }
}
