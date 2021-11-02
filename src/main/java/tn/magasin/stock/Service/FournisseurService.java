package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.IFournisseurService;
import tn.magasin.stock.Repository.FournisseurRepository;
import tn.magasin.stock.entity.Fournisseur;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService implements IFournisseurService {
    public FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public List<Fournisseur> retrieveAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseurById(Long Id) {
        fournisseurRepository.deleteById(Id);

    }

    @Override
    public void deleteFournisseurByObject(Fournisseur fournisseur) {
         fournisseurRepository.delete(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Optional<Fournisseur> retrieveFournisseur(Long Id) {
        return fournisseurRepository.findById(Id);
    }
}
