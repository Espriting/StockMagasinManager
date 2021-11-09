package tn.magasin.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.magasin.stock.IService.ICommandeService;
import tn.magasin.stock.entity.Commande;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
public class CommandeRestController {
    @Autowired
    ICommandeService commandeService;
    @GetMapping("/retrieve-all-commanndes")
    @ResponseBody
    public List<Commande> getCommandes() {
        List<Commande> listCommandes = commandeService.retrieveAllCommande();
        return listCommandes;
    }
    @GetMapping("/retrieve-commannde/{id}")
    @ResponseBody
    public Optional<Commande> getCommandeById(@PathVariable Long id) {
        Optional<Commande> commande = commandeService.retrieveCommande(id);
        return commande;
    }

    @GetMapping("/retrieve-commannde-facture/{idFacture}")
    @ResponseBody
    public Optional<Commande> getCommandeByFacture(@PathVariable Long idFacture) {
        Optional<Commande> commande = commandeService.retrieveCommandeByFacture(idFacture);
        return commande;
    }
    @PostMapping("/addCommande")
    public Commande addCommande(@Valid @RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }

    @DeleteMapping("/remove-Commande/{idCommande}")
    @ResponseBody
    public void removeCommande(@PathVariable("idCommande") Long idCommande) {
        commandeService.deleteCommandeById(idCommande);
    }
    @PutMapping("/modify-Commande")
    @ResponseBody
    public Commande modifyCommande(@RequestBody Commande commande) {
        return commandeService.updateCommande(  commande);
    }
}

