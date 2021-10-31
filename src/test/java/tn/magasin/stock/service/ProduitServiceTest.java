package tn.magasin.stock.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.enumeration.CategorieProduit;
import tn.magasin.stock.Repository.ProduitRepository;
import tn.magasin.stock.Service.ProduitService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ProduitServiceTest {

	
private static final Logger l = LogManager.getLogger(ProduitServiceTest.class);
	
	@Mock
	private ProduitRepository produitRepository;
	
	@InjectMocks
	private ProduitService ps;
	
	@Test
	void addProduitTest() {
	
		Produit p = new Produit(50L ,"code","libelle",70,CategorieProduit.Alimentaire);
		Mockito.when(produitRepository.save(p)).thenReturn(p);
		Produit p1 = ps.addProduct(p);
		assertThat(p).isEqualTo(p1);
	}
	
	@Test
	void retreiveAllProduitsTest() {
		List<Produit> produits = new ArrayList<>();
		produits.add(new Produit());
		produits.add(new Produit());
		produits.add(new Produit());
		Mockito.when(produitRepository.findAll()).thenReturn(produits);
		List<Produit> expected = ps.retrieveAllProducts();
		System.out.println(produits.size());
		assertEquals(expected, produits);
		assertEquals(3, produits.size());	
	}
	
	
	@Test
	void retreiveProduitTest() {
		Produit p = new Produit();
		p.setIdProduit((long)55);
		p.setCategorieProduit(CategorieProduit.Alimentaire);
		p.setCode("code");
		p.setLibelle("libelle");
		p.setPrixUnitaire(50);
		Mockito.when(produitRepository.findById(p.getIdProduit())).thenReturn(Optional.of(p));
		ps.retrieveProduct(p.getIdProduit());
		System.out.println(p);
		assertThat(produitRepository.findById(p.getIdProduit()).get().getCode()).isEqualTo(p.getCode());
		assertThat(produitRepository.findById(p.getIdProduit()).get().getIdProduit()).isEqualTo(p.getIdProduit());	
	}
	
	@Test
	void UpdateProduitTest() {
		Produit p = new Produit();
		p.setIdProduit((long)55);
		p.setCategorieProduit(CategorieProduit.Alimentaire);
		p.setCode("code");
		p.setLibelle("libelle");
		p.setPrixUnitaire(50);
		Produit newp = new Produit();
		newp.setIdProduit(p.getIdProduit());
		newp.setCategorieProduit(CategorieProduit.Electromenager);
		newp.setLibelle("libelle1");
		newp.setPrixUnitaire(100);
		newp.setCode("newCode");
		Mockito.when(produitRepository.findById(p.getIdProduit())).thenReturn(Optional.of(p));
		ps.updateProduct(p.getIdProduit(), newp);
		System.out.println(newp);
		System.out.println(p);
		assertThat(newp.getCode()).isEqualTo(p.getCode());
		assertThat(newp.getCategorieProduit()).isEqualTo(p.getCategorieProduit());
	}
	
	
	@Test
	void deleteProduitTest() {
		Produit p = new Produit();
		p.setIdProduit((long)55);
		p.setCategorieProduit(CategorieProduit.Alimentaire);
		p.setCode("code");
		p.setLibelle("libelle");
		p.setPrixUnitaire(50);
		Mockito.when(produitRepository.findById(p.getIdProduit())).thenReturn(null);
		ps.deleteProduct(p.getIdProduit());
		System.out.println(p);
		assertThat(produitRepository.findById(p.getIdProduit())).isEqualTo(null);
	}
/*	
		@Test
	void addProductTest() throws ParseException {
			
			
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Ajout Produit*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		
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
	
	*/
	
	}