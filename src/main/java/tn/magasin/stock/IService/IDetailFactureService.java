package tn.magasin.stock.IService;

import tn.magasin.stock.entity.DetailFacture;
import tn.magasin.stock.entity.Facture;

import java.util.List;
import java.util.Optional;

public interface IDetailFactureService {
    List<DetailFacture> retrieveAllDetailFactures();
    DetailFacture addDetailFacture(DetailFacture detailFacture);
    void deleteDetailFacture(Long idDetailFacture);
    DetailFacture updateDetailFacture(DetailFacture detailFacture);
    DetailFacture retrieveDetailFacture(Long idDetailFacture);
    List<DetailFacture> retrieveDetailFactureByFacture(Optional<Facture> facture);


}
