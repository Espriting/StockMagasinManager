package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.IDetailFactureService;
import tn.magasin.stock.Repository.DetailFactureRepository;
import tn.magasin.stock.Repository.FactureRepository;
import tn.magasin.stock.entity.DetailFacture;
import tn.magasin.stock.entity.Facture;

import java.util.List;
import java.util.Optional;

@Service
public class DetailFactureService implements IDetailFactureService {
    public final DetailFactureRepository detailFactureRepository;
    @Autowired
    public DetailFactureService(DetailFactureRepository detailFactureRepository) {
        this.detailFactureRepository = detailFactureRepository;
    }
    @Autowired
    FactureRepository factureRepository;
    @Override
    public List<DetailFacture> retrieveAllDetailFactures() {
        List<DetailFacture> detailFactures = (List<DetailFacture>) detailFactureRepository.findAll();
        return detailFactures;
    }
// Service Avancé
    @Override
    public List<DetailFacture> retrieveDetailFactureByFacture(Optional<Facture> facture) {
        return detailFactureRepository.findByFactures(facture);
    }


    @Override
    public DetailFacture addDetailFacture(DetailFacture detailFacture) {
        detailFactureRepository.save(detailFacture);
        return detailFacture;
    }

    @Override
    public void deleteDetailFacture(Long idDetailFacture) {
        if(detailFactureRepository.findById(idDetailFacture).isPresent()){
            detailFactureRepository.deleteById(idDetailFacture);
        }
        else {
            System.out.println("No detailFacture with id "+idDetailFacture+" exists !!!");
        }
    }

    @Override
    public DetailFacture updateDetailFacture(DetailFacture detailFacture ){
        detailFactureRepository.save(detailFacture);
        return detailFacture;
    }

    @Override
    public DetailFacture retrieveDetailFacture(Long idDetailFacture) {
        return detailFactureRepository.findById(idDetailFacture).get();
    }


}
