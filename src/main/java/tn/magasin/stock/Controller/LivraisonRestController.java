package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.ICommandeService;
import tn.magasin.stock.IService.ILivraisonService;
import tn.magasin.stock.IService.IUserService;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;
import tn.magasin.stock.entity.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Livraison management")
@RequestMapping("/livraison")
@CrossOrigin(origins = "http://localhost:4200")
public class LivraisonRestController {
    @Autowired
    ILivraisonService livraisonService;

    @Autowired
    ICommandeService commandeService;

    @Autowired
    IUserService userService;

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

    @GetMapping("/retrieve-Livraison-livreur/{idLivreur}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par Livreur")
    public List<Livraison> getLivraisonByLivreur(@PathVariable("idLivreur") Long idLivreur) {
        User user =  userService.getUserById(idLivreur);
        List<Livraison> livraison = livraisonService.retrieveLivraisonByLivreur(user);
        return livraison;
    }

    @GetMapping("/retrieve-Livraison-etat")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par état")
    public List<Livraison> getLivraisonByEtat() {
        return livraisonService.retrieveLivraisonByEtat(false);
    }


    @PostMapping("/addLivraison")
    @ApiOperation(value = "Ajouter Livraison")
    public Livraison addLivraison(@RequestBody Livraison livraison) {
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

    @GetMapping("/retrieve-Livraison-client/{idClient}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par Client")
    public List<Livraison> getLivraisonByClient(@PathVariable Long idClient) {
        return livraisonService.retrieveLivraisonByClient(idClient);

    }

    @GetMapping("/retrieve-Livraison-commande/{idCommand}")
    @ResponseBody
    @ApiOperation(value = "Récupérer livraions  par Command")
    public List<Livraison> getLivraisonByCommande(@PathVariable("idCommand") Long idCommand) {
        Optional<Commande> commande = commandeService.retrieveCommande(idCommand);
        return livraisonService.retrieveLivraisonByCommande(commande.get());

    }

}
