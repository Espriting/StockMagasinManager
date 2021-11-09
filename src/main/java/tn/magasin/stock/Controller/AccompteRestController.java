package tn.magasin.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.IAccompteService;
import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.entity.Accompte;
import tn.magasin.stock.entity.Facture;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accompte")
public class AccompteRestController {
    @Autowired
    IAccompteService accompteService;
    @GetMapping("/retrieve-all-accomptes")
    @ResponseBody
    public List<Accompte> getAccomptes(){
        List<Accompte> listAccomptes = accompteService.retrieveAllAccomptes();
        return listAccomptes;
    }
    @GetMapping("/retrieve-accompte/{accompte-id}")
    @ResponseBody
    public Optional<Accompte> retrieveAccompte(@PathVariable("accompte-id") Long idAccompte) {
        return accompteService.retrieveAccompte(idAccompte);
    }
    @PostMapping("/add-accompte")
    @ResponseBody
    public Accompte addClient(@RequestBody Accompte a) {
        Accompte accompte = accompteService.addAccompte(a);
        return accompte;
    }
    @DeleteMapping("/remove-accompte/{accompte-id}")
    @ResponseBody
    public void removeAccompte(@PathVariable("accompte-id") Long accompteId) {
        accompteService.deleteAccompteById(accompteId);
    }
    @PutMapping("/modify-accompte")
    @ResponseBody
    public Accompte modifyAccompte(@RequestBody Accompte accompte) {
        return accompteService.updateAccompte(accompte);
    }

}
