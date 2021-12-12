package tn.magasin.stock.IService;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

import tn.magasin.stock.entity.Favoris;
import tn.magasin.stock.entity.Produit;

public interface IFavorisService {
	
	List<Object[]> retriveAllFav(long idUser);
	
	Favoris addFav(Favoris f, long idProduit, long idUser);
	
	void deleteFav(long idFavoris);
	
	Favoris findByIdProduitIdUser(long idProduit,long idUser);

}
