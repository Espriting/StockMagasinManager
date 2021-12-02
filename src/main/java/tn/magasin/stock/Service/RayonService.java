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
            rayonRepository.deleteById(Id);
    }

    @Override
    public void deleteRayonByObject(Rayon rayon) {

        rayonRepository.delete(rayon);

    }

    @Override
    public Rayon updateRayon(Rayon rayon) {
        return rayonRepository.saveAndFlush(rayon);
    }

    @Override
    public Rayon retrieveRayon(Long Id) {
        Optional<Rayon> rayon= rayonRepository.findById(Id);
        if (rayon.isPresent()){
            return rayon.get();
        }else return new Rayon();

    }
}
