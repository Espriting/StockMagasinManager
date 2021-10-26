package tn.magasin.stock.IService;

import java.util.List;
import java.util.Optional;

import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.User;


public interface IFactureService {
	 List<Facture>retrieveALLFactures() ;
	    Facture addFacture(Facture facture);
	    void deleteFactureById(Long Id);
	    
	    // Boolean deleteFactureByObject(Facture);
	     Facture updateFacture(Facture facture);
	     Optional<Facture> retrieveFacture(Long Id);
		

}
