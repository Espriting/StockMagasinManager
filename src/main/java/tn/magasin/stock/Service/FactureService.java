package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.IFactureService;
import tn.magasin.stock.Repository.FactureRepository;
import tn.magasin.stock.Repository.UserRepository;
import tn.magasin.stock.entity.DetailFacture;
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
    @Autowired
    UserService userService;
    @Autowired
    DetailFactureService detailFactureService;


    @Override
    public List<Facture> retrieveALLFactures() {
        return factureRepository.findAll();
    }
// Service Avancé
    @Override
    public List<Facture> retrieveALLFacturesByUser(User user) {
        return factureRepository.findByUser(user);
    }

// Service Avancé
    @Override
    public Facture addFacture(Facture facture,Long id) {
        facture.setUser(userService.getUserById(id));
        factureRepository.save(facture);
        DetailFacture detailFacture=new DetailFacture();
        detailFacture.setFactures(facture);
        detailFacture.setMontantRemise(facture.getMontantRemise());
        detailFacture.setPrixTotal(facture.getMontantFacture()-facture.getMontantRemise());
        detailFactureService.addDetailFacture(detailFacture);
        return facture;
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
    public Facture addfacture (Facture facture) {
        return factureRepository.save(facture);
    }




    //Service Avancé
   /* @Override
    public List<Facture> retrieveFactureByClient(Long id) {
        List<Facture> factures = new ArrayList<Facture>();
        User u  = userRepository.findById(id).orElse(null); //retrieve factures from clients
        u.getFacture().forEach(facture -> {            // remplir une liste avec les factures de clients
            factures.add(facture);
        });
        return factures;            //retourner la liste


    }
    //Service avancé
*/

    }

