package tn.magasin.stock.Repository;
import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.magasin.stock.Service.CommandeService;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.Livraison;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@Slf4j
public class CommandRepositoryTest {
   @Mock
   private CommandeRepository commandeRepository;
    @InjectMocks
    CommandeService cs;

@Test
    public void addCommandeTest() throws ParseException{
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse("2007-02-15");
    Date dateCommande = dateFormat.parse("2007-03-23");

    Commande c = new Commande(new Facture(2L, 22,250,date,true), new Livraison(3L), dateCommande);
    Mockito.when(commandeRepository.save(c)).thenReturn(c);
    Commande c1 = cs.addCommande(c);
    log.info(""+c);
    log.info(""+c1);
    assertThat(c).isEqualTo(c1);
}
    @Test
    public void retreiveCommandeTest()  throws ParseException{
        Commande c = new Commande();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2007-02-15");
        c.setDateCommande(date);
        Mockito.when(commandeRepository.findById(c.getIdCommande())).thenReturn(Optional.of(c));
        cs.retrieveCommande(c.getIdCommande());
        System.out.println(c);
        assertThat(commandeRepository.findById(c.getIdCommande()).get().getDateCommande()).isEqualTo(c.getDateCommande());
    }

    @Test
    public void UpdateCommandeTest() throws ParseException{
        Commande c = new Commande();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2007-02-15");
       c.setDateCommande(date);
        Commande c1 = new Commande();
        Date dateUP = dateFormat.parse("2021-02-15");
        Mockito.when(commandeRepository.findById(c.getDateCommande().getTime())).thenReturn(Optional.of(c));
        cs.updateCommande(c1);
        System.out.println(c1);
        assertThat(c1.getDateCommande()).isEqualTo(c.getDateCommande());

    }
}
