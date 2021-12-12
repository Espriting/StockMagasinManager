package tn.magasin.stock.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.magasin.stock.entity.Favoris;
import tn.magasin.stock.entity.Produit;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, Long> {
/*
	@Query(value="SELECT p.id_produit, p.categorie_produit, p.code ,p.libelle , p.prix_unitaire ,p.picture, p.date_creation "
			+ "FROM produit p "
			+ "INNER JOIN favoris_produits fp ON p.id_produit=fp.produits_id_produit "
			+ "INNER JOIN favoris f ON fp.favoris_id_favoris=f.id_favoris "
			+ "INNER JOIN user u ON f.user_id=u.id "
			+ "WHERE u.id=:idUser",nativeQuery = true)
	List retriveAllFav(long idUser);
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO favoris_produits(favoris_id_favoris,produits_id_produit) VALUES(:idFavoris,:idProduit)",nativeQuery = true)
	void addFavProd(long idFavoris , long idProduit);
	
	@Query(value="SELECT * FROM favoris WHERE user_id=:idUser",nativeQuery = true)
	Favoris findFavByIdClient(Long idUser);
	
	@Query(value="SELECT fp.favoris_id_favoris, fp.produits_id_produit "
			+ "from favoris_produits fp "
			+ "INNER JOIN favoris f ON fp.favoris_id_favoris = f.id_favoris "
			+ "INNER JOIN user u ON f.user_id=u.id "
			+ "where fp.produits_id_produit =:idProduit AND u.id =:idUser",nativeQuery = true)
	Object findFavProdByIdProd(Long idProduit, Long idUser);
	
	@Transactional
	@Modifying
	@Query(value ="DELETE FROM favoris_produits WHERE ",nativeQuery = true)
	void deleteFavProd(long idFavoris , long idProduit);
	*/
	
	@Query(value="SELECT f.id_favoris, p.id_produit, p.categorie_produit, p.code ,p.libelle , p.prix_unitaire ,p.picture "
			+ "FROM produit p "
			+ "INNER JOIN favoris f ON f.produit_id_produit=p.id_produit "
			+ "INNER JOIN user u ON f.user_id=u.id "
			+ "WHERE F.user_id=:idUser",nativeQuery = true)
	List<Object[]> retriveAllFav(long idUser);
	
	@Query(value="SELECT * FROM favoris f WHERE f.produit_id_produit=:idProduit AND f.user_id=:idUser",nativeQuery = true)
	Favoris findByIdProduitIdUser(long idProduit,long idUser);
	
}
