package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.Repository.AccompteRepository;

@Service
public class AccompteService {
    public final AccompteRepository accompteRepository;

    @Autowired
    public AccompteService(AccompteRepository accompteRepository) {
        this.accompteRepository = accompteRepository;
    }
}
