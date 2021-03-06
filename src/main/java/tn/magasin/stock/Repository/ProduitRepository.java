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
	
	
	/*
	 * @Query(value =
	 * "SELECT s.id_produit, s.categorie_produit, s.code, s.libelle, s.prix_unitaire "
	 * + "FROM sumqte AS s" , nativeQuery = true) List BestSellerProduct();
	 * 
	 * 
	 * @Query(value =
	 * "SELECT m.id_produit, m.categorie_produit, m.code, m.libelle, m.prix_unitaire "
	 * + "FROM mostliked AS m" , nativeQuery = true) List MostLikedProducts();
	 */
	
	@Query(value = "SELECT SUM(df.qte) as somme ,p.id_produit , p.categorie_produit , p.code , "
			+ "p.date_creation , p.libelle ,p.prix_unitaire,p.picture FROM detail_facture df "
			+ "INNER JOIN detail_facture_produits dfp ON df.id_detail_facture=dfp.detail_facture_id_detail_facture "
			+ "INNER JOIN produit p ON dfp.produits_id_produit = p.id_produit "
			+ "INNER JOIN facture f ON (f.id_facture=df.factures_id_facture)AND f.date_facture=DATE(NOW()) "
			+ "GROUP BY dfp.produits_id_produit ORDER BY somme DESC LIMIT 3 ", nativeQuery = true)
	List BestSellerProduct();
	
	@Query(value = "SELECT COUNT(*) AS nbrLikes , p.id_produit , p.categorie_produit , p.code ,"
			+ " p.date_creation , p.libelle , p.prix_unitaire , p.picture "
			+ "FROM Feedback f JOIN produit p ON f.produit_id_produit = p.id_produit "
			+ "AND f.reaction='Like' GROUP BY f.produit_id_produit ORDER BY nbrLikes DESC LIMIT 3 " , nativeQuery = true)
	List MostLikedProducts();
	
	
	@Query(value = "SELECT id_produit from produit p where p.date_creation BETWEEN DATE(NOW()) - INTERVAL '7' DAY AND DATE(NOW())", nativeQuery = true)
	List NewestProducts();
	
	@Query(value = "SELECT count(*) from produit", nativeQuery = true)
	long CountProducts();
	
}