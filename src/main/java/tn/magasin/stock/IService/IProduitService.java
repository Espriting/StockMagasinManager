package tn.magasin.stock.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.enumeration.CategorieProduit;

public interface IProduitService {
	
	List<Produit> retrieveAllProducts();

	Produit addProduct(Produit p) ;

	void deleteProduct(Long idProduit);

	Produit updateProduct(Produit p);
	
	Produit retrieveProduct(Long idProduit);
	
	List statCategorieProduit();
	
	List BestSellerProduct();

	List MostLikedProduct();
	//List<Produit>retriveByDate();

}
