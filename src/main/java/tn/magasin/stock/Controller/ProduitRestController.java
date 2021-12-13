package tn.magasin.stock.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.magasin.stock.Service.ProduitService;
import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.enumeration.CategorieProduit;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitService ps;
	
	
	@GetMapping("/display")
	public List<Produit> getProduits() {
	List<Produit> listProduits = ps.retrieveAllProducts();
	return listProduits;
	}
	
	@PostMapping("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Produit addProduit(@Valid @RequestBody Produit p) {
		Produit p1 = ps.addProduct(p);
		return p1;
	}

	@PutMapping("/update")
	public Produit updateProduit(@RequestBody Produit p) {
    	return ps.updateProduct(p);	
		
	}
	
	@DeleteMapping("/delete/{idProduit}")
	public void deleteProduit(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
    	ps.deleteProduct(idProduit);
	}
	
	@GetMapping("search/{idProduit}")
	public Produit searchProduit(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
    	Produit p = ps.retrieveProduct(idProduit);
    	return p ;
	}
	
	@GetMapping("statCategorieProduit")
	public List statCategorieProduit() {
		List m1 = ps.statCategorieProduit();
		
		return m1;
	} 
	
	@GetMapping("BestSellerProduct")
	public List BestSellerProduct() {
		return ps.BestSellerProduct();
	}
	
	
	@GetMapping("MostLikedProduct")
	public List MostLikedProduct() {
		return ps.MostLikedProduct();
	}
	
	
	@GetMapping("newestProducts")
	public List NewestProducts() {
		return ps.NewestProducts();
	}
	
	@GetMapping("countProducts")
	public long CountProducts() {
		return ps.CountProducts();
	}
}
