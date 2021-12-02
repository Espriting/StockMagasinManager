package tn.magasin.stock.IService;

import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Facture;

import java.util.List;
import java.util.Optional;

public interface ICommandeService {
    List<Commande> retrieveAllCommande();
    Commande addCommande(Commande commande);
    void deleteCommandeById(Long Id);
    Commande updateCommande( Commande commandeUp);
    Optional<Commande> retrieveCommande(Long Id);
    Optional<Commande> retrieveCommandeByFacture(Long Id);
    List<Commande> retrieveCommandeByClient(Long Id);
}
