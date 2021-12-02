package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.ILivraisonService;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Livraison management")
@RequestMapping("/livraison")
public class LivraisonRestController {
    @Autowired
    ILivraisonService livraisonService;

    @GetMapping("/retrieve-all-Livraisons")
    @ResponseBody
    @ApiOperation(value = "Récupérer la liste de tous les liraison")
    public List<Livraison> getLivraisons() {
        List<Livraison> listLivraisons = livraisonService.retrieveAllLivraison();
        return listLivraisons;
    }

    @GetMapping("/retrieve-Livraison/{id}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par id")
    public Optional<Livraison> getLivraisonById(@PathVariable Long id) {
        Optional<Livraison> livraison = livraisonService.retrieveLivraison(id);
        return livraison;
    }

    @GetMapping("/retrieve-Livraison/{idLivreur}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par Livreur")
    public Optional<Livraison> getLivraisonByLivreur(@PathVariable Long idLivreur) {
        Optional<Livraison> livraison = livraisonService.retrieveLivraisonByLivreur(idLivreur);
        return livraison;
    }

    @GetMapping("/retrieve-Livraison/{idClient}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par Client")
    public Optional<Livraison> getLivraisonByClient(@PathVariable Long idClient) {
        Optional<Livraison> livraison = livraisonService.retrieveLivraisonByClient(idClient);
        return livraison;
    }

    @GetMapping("/retrieve-Livraison/{idCommand}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par Etat Command")
    public Optional<Livraison> getLivraisonByEtatCommande(@PathVariable Boolean etat) {
        Optional<Livraison> livraison = livraisonService.retrieveLivraisonByEtatCommande(etat);
        return livraison;
    }

    @PostMapping("/addLivraison")
    @ApiOperation(value = "Ajouter Livraison")
    public Livraison addLivraison(@Valid @RequestBody Livraison livraison) {
        return livraisonService.addLivraison(livraison);
    }

    @DeleteMapping("/remove-Livraison/{idLivraison}")
    @ResponseBody
    @ApiOperation(value = "Supprimer Livraison")
    public void removeCLivraison(@PathVariable("idLivraison") Long idLivraison) {
        livraisonService.deleteLivraisonById(idLivraison);
    }

    @PutMapping("/modify-Livraison")
    @ResponseBody
    @ApiOperation(value = "Modifier Livraison")
    public Livraison modifyCommaLivraison(@RequestBody Livraison livraison) {
        return livraisonService.updateLivraison(livraison);
    }

}
