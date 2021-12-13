package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.ICommandeService;
import tn.magasin.stock.entity.Commande;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Commande management")
@RequestMapping("/commande")
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeRestController {
    @Autowired
    ICommandeService commandeService;


    @GetMapping("/retrieve-all-commanndes")
    @ResponseBody
    @ApiOperation(value = "Récupérer la liste de tous les commandes")
    public List<Commande> getCommandes() {
        List<Commande> listCommandes = commandeService.retrieveAllCommande();
        return listCommandes;
    }

    @GetMapping("/retrieve-commannde/{id}")
    @ResponseBody
    @ApiOperation(value = "Récupérer commande par ID")
    public Optional<Commande> getCommandeById(@PathVariable Long id) {
        Optional<Commande> commande = commandeService.retrieveCommande(id);
        return commande;
    }

    @GetMapping("/retrieve-commannde-client/{idClient}")
    @ResponseBody
    @ApiOperation(value = "Récupérer commande par Client")
    public List<Commande> getCommandeByClient(@PathVariable Long idClient) {
        List<Commande> commande = commandeService.retrieveCommandeByClient(idClient);
        return commande;
    }
    @GetMapping("/retrieve-commannde-facture/{idFacture}")
    @ResponseBody
    @ApiOperation(value = "Récupérer commande par facture")
    public Optional<Commande> getCommandeByFacture(@PathVariable Long idFacture) {
        Optional<Commande> commande = commandeService.retrieveCommandeByFacture(idFacture);
        return commande;
    }


    @PostMapping("/addCommande")
    @ApiOperation(value = "Ajouter commande")
    public Commande addCommande(@RequestBody Commande commande) {

        return commandeService.addCommande(commande);
    }

    @DeleteMapping("/remove-Commande/{idCommande}")
    @ResponseBody
    @ApiOperation(value = "Supprimer commande")
    public void removeCommande(@PathVariable("idCommande") Long idCommande) {
        commandeService.deleteCommandeById(idCommande);
    }

    @PutMapping("/modify-Commande")
    @ResponseBody
    @ApiOperation(value = "Modifier Commande")
    public Commande modifyCommande(@RequestBody Commande commande) {
        return commandeService.updateCommande(commande);
    }
}

