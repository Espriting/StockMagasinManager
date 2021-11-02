package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.magasin.stock.IService.IRayonService;
import tn.magasin.stock.Repository.RayonRepository;
import tn.magasin.stock.entity.Rayon;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RayonService implements IRayonService {
    public final RayonRepository rayonRepository;
    @Autowired
    public RayonService(RayonRepository rayonRepository) {
        this.rayonRepository = rayonRepository;
    }

    @Override
    public List<Rayon> retrieveAllRayon() {
        return rayonRepository.findAll();
    }

    @Override
    public Rayon addRayon(Rayon stock) {
        return rayonRepository.save(stock);
    }

    @Override
    public void deleteRayonById(Long Id) {

    }

    @Override
    public Boolean deleteRayonByObject(Rayon rayon) {
        return null;
    }

    @Override
    public Rayon updateRayon(Rayon rayon) {
        return null;
    }

    @Override
    public Optional<Rayon> retrieveRayon(Long Id) {
        return Optional.empty();
    }
}
