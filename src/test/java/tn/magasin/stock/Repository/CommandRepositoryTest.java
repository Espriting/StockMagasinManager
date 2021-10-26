package tn.magasin.stock.Repository;

import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.magasin.stock.Service.CommandeService;
import tn.magasin.stock.entity.Commande;

import java.text.ParseException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandRepositoryTest {
    @Autowired
    CommandeService cs;
    private static final Logger l = LogManager.getLogger(CommandRepositoryTest.class);
    @Test
    public void     testRetrieveCommand () throws  Exception{
        Optional<Commande> commande = cs.retrieveCommandeByFacture(1L);
        TestCase.assertNotNull(commande.get().getIdCommande());
        l.info("retrieve : "+ commande.get().getIdCommande());
    }
}
