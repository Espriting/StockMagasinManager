package tn.magasin.stock.Repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import tn.magasin.stock.Service.FournisseurService;
import tn.magasin.stock.entity.Fournisseur;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.logging.log4j.*;


@SpringBootTest
class FournisseurRepositoryTest {
    @Autowired
    private FournisseurRepository underTest;
    private static final Logger l = LogManager.getLogger(FournisseurRepository.class);
    @AfterEach
    void cleanTable(){
        underTest.deleteAll();

    }
    @Test
    void selectExistsFournisseur() {
        //what I give
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setCode("063262550");
       underTest.save(fournisseur);
       l.fatal("add Fournisseur"+fournisseur);
        //when
        boolean expected=underTest.selectExistsFournisseur("06326200");
        //then
        assertThat(expected).isFalse();


    }
}