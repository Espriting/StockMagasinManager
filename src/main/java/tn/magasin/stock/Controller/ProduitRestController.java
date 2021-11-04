package tn.magasin.stock.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
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

	@PutMapping("/update/{idProduit}")
	public Produit updateProduit(@PathVariable(value = "idProduit") Long idProduit, @Valid @RequestBody Produit p) {
    	Produit p1 = ps.updateProduct(idProduit, p);	
		return p1;
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
	
	
	
	

}
