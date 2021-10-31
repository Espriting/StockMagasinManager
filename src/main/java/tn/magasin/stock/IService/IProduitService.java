package tn.magasin.stock.IService;

import java.util.List;

import tn.magasin.stock.entity.Produit;

public interface IProduitService {
	
	List<Produit> retrieveAllProducts();

	Produit addProduct(Produit p);

	void deleteProduct(Long idProduit);

	Produit updateProduct(Long idProduit ,Produit p);

	Produit retrieveProduct(Long idProduit);
	
	//List<Produit>retriveByDate();

}
