package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Accompte management")
public class AccompteRestController {
    @Autowired
    IAccompteService accompteService;

    @ApiOperation(value = "Récupérer la liste des accomptes")
    @GetMapping("/retrieve-all-accomptes")
    @ResponseBody
    public List<Accompte> getAccomptes(){
        List<Accompte> listAccomptes = accompteService.retrieveAllAccomptes();
        return listAccomptes;
    }

    @ApiOperation(value = "Récupérer un accompte")
    @GetMapping("/retrieve-accompte/{accompte-id}")
    @ResponseBody
    public Optional<Accompte> retrieveAccompte(@PathVariable("accompte-id") Long idAccompte) {
        return accompteService.retrieveAccompte(idAccompte);
    }

    @ApiOperation(value = "Ajouter un accompte")
    @PostMapping("/add-accompte")
    @ResponseBody
    public Accompte addClient(@RequestBody Accompte a) {
        Accompte accompte = accompteService.addAccompte(a);
        return accompte;
    }

    @ApiOperation(value = "Supprimer un accompte")
    @DeleteMapping("/remove-accompte/{accompte-id}")
    @ResponseBody
    public void removeAccompte(@PathVariable("accompte-id") Long accompteId) {
        accompteService.deleteAccompteById(accompteId);
    }

    @ApiOperation(value = "Modifier un accompte")
    @PutMapping("/modify-accompte")
    @ResponseBody
    public Accompte modifyAccompte(@RequestBody Accompte accompte) {
        return accompteService.updateAccompte(accompte);
    }

}
