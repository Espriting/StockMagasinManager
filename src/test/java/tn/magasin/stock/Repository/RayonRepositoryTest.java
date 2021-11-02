package tn.magasin.stock.Repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.magasin.stock.entity.Rayon;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RayonRepositoryTest {
    @Autowired
    private RayonRepository rayonTest;
    private static final Logger l = LogManager.getLogger(FournisseurRepository.class);
    @Test
    void produitExistInRayon() {
        Rayon rayon=new Rayon();
        rayon.setCode("xxx");
        rayonTest.save(rayon);
        Boolean expected=rayonTest.produitExistInRayon(rayon.getIdRayon());
        l.info("produit exist"+expected);


    }
}