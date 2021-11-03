package tn.magasin.stock.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.magasin.stock.IService.IAccompte;
import tn.magasin.stock.Repository.AccompteRepository;
import tn.magasin.stock.entity.Accompte;

@Service
public class AccompteService implements IAccompte {
    public final AccompteRepository accompteRepository;

    @Autowired
    public AccompteService(AccompteRepository accompteRepository) {
        this.accompteRepository = accompteRepository;
    }
    @Override
    public List<Accompte> retrieveAllAccomptes() {
        return accompteRepository.findAll();
    }

    @Override
    public Accompte addAccompte( Accompte accompte) {
        return accompteRepository.save(accompte);
    }


    @Override
    public void deleteAccompteById(Long Id) {
       accompteRepository.deleteById(Id);
    }


    @Override
    public Accompte updateAccompte(Accompte accompte) {
        return accompteRepository.save(accompte);
    }

    @Override
    public Optional<Accompte> retrieveAccompte(Long Id) {


        return accompteRepository.findById(Id);
    }
}
