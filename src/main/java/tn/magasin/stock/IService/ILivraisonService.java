package tn.magasin.stock.IService;

import tn.magasin.stock.entity.Livraison;

import java.util.List;
import java.util.Optional;

public interface ILivraisonService {
    List<Livraison> retrieveAllLivraison();
    Livraison addLivraison(Livraison livraison);
    void deleteLivraisonById(Long Id);
    Livraison updateLivraison(Livraison livraison);
    Optional<Livraison> retrieveLivraison(Long Id);
}
