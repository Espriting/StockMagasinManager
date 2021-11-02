package tn.magasin.stock.IService;

import tn.magasin.stock.entity.Rayon;
import tn.magasin.stock.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface IRayonService {
    List<Rayon> retrieveAllRayon();
    Rayon addRayon(Rayon stock);
    void deleteRayonById(Long Id);
     Boolean deleteRayonByObject(Rayon rayon);
    Rayon updateRayon(Rayon rayon);
    Optional<Rayon> retrieveRayon(Long Id);
}
