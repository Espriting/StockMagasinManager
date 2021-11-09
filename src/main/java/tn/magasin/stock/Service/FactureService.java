package tn.magasin.stock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.Repository.FactureRepository;
import tn.magasin.stock.entity.Facture;


@Service
public  class FactureService implements IFactureService {
    public final FactureRepository factureRepository;
    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }
    @Override
    public List<Facture> retrieveALLFactures() {
        return factureRepository.findAll();
    }
    @Override 
    public Facture addFacture (Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFactureById(Long Id) {
        factureRepository.deleteById(Id);
    }


   
    @Override
    public Facture updateFacture (Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Optional<Facture> retrieveFacture(Long idFacture) {


        return factureRepository.findById(idFacture);
    }
}
