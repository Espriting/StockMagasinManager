package tn.magasin.stock.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.magasin.stock.entity.Feedback;
import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.enumeration.CategorieProduit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@Query("SELECT p.categorieProduit, COUNT(p) FROM Produit p GROUP BY p.categorieProduit   ")
	List statCategorieProduit();
	
	@Query(value = "SELECT s.id_produit, s.categorie_produit, s.code, s.libelle, s.prix_unitaire "
			+ "FROM sumqte AS s" , nativeQuery = true)
	List BestSellerProduct();
	
	
	@Query(value = "SELECT m.id_produit, m.categorie_produit, m.code, m.libelle, m.prix_unitaire "
			+ "FROM mostliked AS m" , nativeQuery = true)
	List MostLikedProducts();
	
}