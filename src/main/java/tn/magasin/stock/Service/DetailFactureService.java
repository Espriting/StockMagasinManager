package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.Repository.DetailFactureRepository;

@Service
public class DetailFactureService {
    public final DetailFactureRepository detailFactureRepository;
    @Autowired
    public DetailFactureService(DetailFactureRepository detailFactureRepository) {
        this.detailFactureRepository = detailFactureRepository;
    }
}
