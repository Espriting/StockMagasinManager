package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.Repository.RayonRepository;

@Service
public class RayonService {
    public final RayonRepository rayonRepository;
    @Autowired
    public RayonService(RayonRepository rayonRepository) {
        this.rayonRepository = rayonRepository;
    }
}
