package tn.magasin.stock.Repository;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.magasin.stock.Service.FactureService;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.enumeration.CategorieClient;
import tn.magasin.stock.enumeration.Profession;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureRepositoryTest {
	@Autowired
	FactureService fs;
	private static final Logger l = LogManager.getLogger(FactureRepositoryTest.class);
	@Test
	public void testRetrieveFacture() {
	Optional<Facture> facture = fs.retrieveFacture(1L);
	l.info("retrieve : "+ facture.get().getMontantFacture());
	}
	@Test
	public void testAddFacture() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("1997-03-23");
		Facture f = new Facture(20,1000,date,false);
		fs.addFacture(f);
	}
}
