package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.ICommandeService;
import tn.magasin.stock.Repository.CommandeRepository;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements ICommandeService {
    public final CommandeRepository commandeRepository;
    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }
    @Override
    public List<Commande> retrieveAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommandeById(Long Id) {
        commandeRepository.deleteById(Id);
    }


    @Override
    public Commande updateCommande(Commande commandeUp) {
        return commandeRepository.save(commandeUp);
    }

    @Override
    public Optional<Commande> retrieveCommande(Long Id) {


        return commandeRepository.findById(Id);
    }
    @Override
    public Optional<Commande> retrieveCommandeByFacture(Long Id) {

        return commandeRepository.FindByFactures(Id);
    }
    @Override
    public Optional<Commande> retrieveCommandeByClient(Long Id) {
        return commandeRepository.FindCommandeByClient(Id);
    }

}
