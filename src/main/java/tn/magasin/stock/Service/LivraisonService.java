package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.ILivraisonService;
import tn.magasin.stock.Repository.LivraisonRepository;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService implements ILivraisonService {
    public final LivraisonRepository livraisonRepository;

    @Autowired
    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }
    @Override
    public List<Livraison> retrieveAllLivraison() {
        return livraisonRepository.findAll();
    }

    @Override
    public Livraison addLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    @Override
    public void deleteLivraisonById(Long Id) {
        livraisonRepository.deleteById(Id);
    }


    @Override
    public Livraison updateLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    @Override
    public Optional<Livraison> retrieveLivraison(Long Id) {
        return livraisonRepository.findById(Id);
    }

    @Override
    public List<Livraison> retrieveLivraisonByLivreur(User user) {
        return livraisonRepository.findByUser(user);
    }



    @Override
    public List<Livraison> retrieveLivraisonByClient(Long Id) {
        return livraisonRepository.FindLivraisonByClient(Id);
    }
    @Override
    public List<Livraison> retrieveLivraisonByCommande(Commande commande) {
        return livraisonRepository.findByCommande(commande);
    }


    @Override
    public List<Livraison> retrieveLivraisonByEtat(Boolean etat) {
        return livraisonRepository.findByEtat(etat);
    }

}
