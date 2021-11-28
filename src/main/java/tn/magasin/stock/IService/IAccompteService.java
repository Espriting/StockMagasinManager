package tn.magasin.stock.IService;
import java.util.List;
import java.util.Optional;

import tn.magasin.stock.entity.Accompte;
import tn.magasin.stock.entity.Accompte;


public interface IAccompteService {
	
	Accompte addAccompte(Accompte accompte);
    void deleteAccompteById(Long Accompte);
   // Boolean deleteAccompterByObject(Accompte accompte);
    Accompte updateAccompte(Accompte accompte);
    Optional<Accompte> retrieveAccompte(Long Id);
    public List<Accompte> retrieveAllAccomptes() ;

}
