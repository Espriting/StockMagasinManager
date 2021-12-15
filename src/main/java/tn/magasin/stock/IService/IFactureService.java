package tn.magasin.stock.IService;

import java.util.List;
import java.util.Optional;

import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.User;


public interface IFactureService {
    List<Facture> retrieveALLFactures();
    List<Facture> retrieveALLFacturesByUser(User user);

    Facture addFacture(Facture facture,Long id);

    void deleteFactureById(Long Id);

    // Boolean deleteFactureByObject(Facture);
    Facture updateFacture(Facture facture);

    Optional<Facture> retrieveFacture(Long Id);
    Facture addfacture(Facture facture);

 // List<Facture> retrieveFactureByClient(Long id);




}
