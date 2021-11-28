package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.Repository.DetailFactureRepository;

@Service
public class DetailProduitService {
    public final DetailFactureRepository detailFactureRepository;
    @Autowired
    public DetailProduitService(DetailFactureRepository detailFactureRepository) {
        this.detailFactureRepository = detailFactureRepository;
    }
}
