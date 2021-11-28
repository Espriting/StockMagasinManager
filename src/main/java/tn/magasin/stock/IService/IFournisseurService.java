package tn.magasin.stock.IService;

import tn.magasin.stock.entity.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface IFournisseurService {
    List<Fournisseur> retrieveAllFournisseur();
    Fournisseur addFournisseur(Fournisseur fournisseur);
    void deleteFournisseurById(Long Id);
    void deleteFournisseurByObject(Fournisseur fournisseur);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    Optional<Fournisseur> retrieveFournisseur(Long Id);
}
