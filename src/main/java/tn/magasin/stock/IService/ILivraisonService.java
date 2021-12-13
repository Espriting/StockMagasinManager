package tn.magasin.stock.IService;

import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

public interface ILivraisonService {
    List<Livraison> retrieveAllLivraison();
    Livraison addLivraison(Livraison livraison);
    void deleteLivraisonById(Long Id);
    Livraison updateLivraison(Livraison livraison);
    Optional<Livraison> retrieveLivraison(Long Id);
    List<Livraison> retrieveLivraisonByLivreur(User user);
    List<Livraison> retrieveLivraisonByClient(Long Id);
    List<Livraison> retrieveLivraisonByEtat(Boolean etat);
    List<Livraison> retrieveLivraisonByCommande(Commande commande);
}
