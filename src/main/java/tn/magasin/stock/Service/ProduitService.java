package tn.magasin.stock.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.enumeration.CategorieProduit;
import tn.magasin.stock.IService.IProduitService;
import tn.magasin.stock.Repository.ProduitRepository;


@Service
public class ProduitService implements IProduitService{
    
    @Autowired
    ProduitRepository produitRepository;
    
    private static final Logger l = LogManager.getLogger(ProduitService.class);

    @Override
	public List<Produit> retrieveAllProducts() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		
			for(Produit produit : produits) {
				l.info("PRODUIT: "+ produit);
			}
			
		return produits;
	}

    @Override
	public Produit addProduct(@Valid @RequestBody Produit c) {
		return produitRepository.save(c);
	}

    @Override
	public void deleteProduct(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
    	produitRepository.deleteById(idProduit);
	}

    @Override
	public Produit updateProduct(@Valid @RequestBody Produit p) {
    	//Produit p1 = retrieveProduct(idProduit);
		
    	//p1.setCode(p.getCode()); 
    	//p1.setLibelle(p.getLibelle());
    	//p1.setPrixUnitaire(p.getPrixUnitaire());
    	//p1.setCategorieProduit(p.getCategorieProduit());
    	
    			
		return produitRepository.save(p);
	}

    @Override
	public Produit retrieveProduct(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
    	Produit p = produitRepository.findById(idProduit).orElseThrow(() -> new NoSuchElementException("Product not found for this id :: " + idProduit)); ;
    	l.info("Produit: "+ p);
    	return p ;
	}

	@Override
	public List statCategorieProduit() {
		List m1 = produitRepository.statCategorieProduit();
		//for(Map.Entry mapEntry : m1.entrySet()) {
		//	l.info("Map: "+ mapEntry);
		//}
		return m1;
	}
	
	@Override
	public List BestSellerProduct() {
		return produitRepository.BestSellerProduct();
	}
	
	@Override
	public List MostLikedProduct() {
		return produitRepository.MostLikedProducts();
	}
    
    
}
