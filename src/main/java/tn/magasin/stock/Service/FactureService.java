package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.Repository.FactureRepository;
import tn.magasin.stock.Repository.UserRepository;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;


@Service
public class FactureService implements IFactureService {
    public final FactureRepository factureRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Autowired
    UserRepository userRepository;


    @Override
    public List<Facture> retrieveALLFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture addFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFactureById(Long Id) {
        factureRepository.deleteById(Id);
    }


    @Override
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Optional<Facture> retrieveFacture(Long idFacture) {


        return factureRepository.findById(idFacture);
    }

    @Override
    public List<Facture> retrieveFactureByClient(User user) {
        return factureRepository.findByUser(user);

    }




    }

