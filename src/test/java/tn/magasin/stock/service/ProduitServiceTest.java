package tn.magasin.stock.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.enumeration.CategorieProduit;
import tn.magasin.stock.Repository.ProduitRepository;
import tn.magasin.stock.Service.ProduitService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProduitServiceTest {

	
private static final Logger l = LogManager.getLogger(ProduitServiceTest.class);
	
	@Autowired
	private ProduitService ps;
	
	
		@Test
	void addProductTest() throws ParseException {
			
			
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Ajout Produit*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2015-03-23");
		Produit p = new Produit("code","libele",80, CategorieProduit.Electromenager);
		
		ps.addProduct(p);
		l.info(p);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Produit ajoute!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	} 
	
	@Test
	void retreiveAllProductsTest() {
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Liste des Produits*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		ps.retrieveAllProducts();
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Liste des Produits affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		
	}
	
	
	
	@Test
	void retreiveProduitTest() {
		
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Affichage du produit avec id = "+3+" *************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		ps.retrieveProduct((long) 3);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Produit avec id = "+3+" est affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		
		
	}
	
	@Test
	void UpdateProductTest() {
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Modification du produit avec id = "+3+" est affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		Produit p1 = ps.retrieveProduct((long) 3);
		p1.setCode("codeUpdated1"); 
		p1.setLibelle("libelleUpdated");
		p1.setPrixUnitaire(80);
		p1.setCategorieProduit(CategorieProduit.Alimentaire);
		ps.updateProduct((long)3 ,p1);
		l.info("Client: " + p1.toString());
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Produit avec id = "+3+" est modifie!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	}
	
	@Test
	void deleteProductTest() {
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Suppression du produit avec id = "+4+" est affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		ps.deleteProduct((long) 4);
		l.info("Produit suprime!!");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Produit avec id = "+4+" est supprime!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	}
	
	
	
	}