package tn.magasin.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.ILivraisonService;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livraison")
public class LivraisonRestController {
    @Autowired
    ILivraisonService livraisonService;
    @GetMapping("/retrieve-all-Livraisons")
    @ResponseBody
    public List<Livraison> getLivraisons() {
        List<Livraison> listLivraisons = livraisonService.retrieveAllLivraison();
        return listLivraisons;
    }
    @GetMapping("/retrieve-Livraison/{id}")
    @ResponseBody
    public Optional<Livraison> getLivraisonById(@PathVariable Long id) {
        Optional<Livraison> livraison = livraisonService.retrieveLivraison(id);
        return livraison;
    }
    @PostMapping("/addLivraison")
    public Livraison addLivraison(@Valid @RequestBody Livraison livraison) {
        return livraisonService.addLivraison(livraison);
    }
    @DeleteMapping("/remove-Livraison/{idLivraison}")
    @ResponseBody
    public void removeCLivraison(@PathVariable("idLivraison") Long idLivraison) {
        livraisonService.deleteLivraisonById(idLivraison);
    }
    @PutMapping("/modify-Livraison")
    @ResponseBody
    public Livraison modifyCommaLivraison(@RequestBody Livraison livraison) {
        return livraisonService.updateLivraison(livraison);
    }

}
