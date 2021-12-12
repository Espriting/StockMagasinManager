package tn.magasin.stock.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.magasin.stock.entity.Favoris;
import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.entity.User;
import tn.magasin.stock.IService.IFavorisService;
import tn.magasin.stock.Repository.FavorisRepository;

@Service
public class FavorisService implements IFavorisService{
	
	@Autowired
	FavorisRepository favorisRepository;

	@Override
	public List<Object[]> retriveAllFav(long idUser) {
		
		return favorisRepository.retriveAllFav(idUser);
	}

	@Override
	public Favoris addFav(Favoris f, long idProduit, long idUser) {
		f.setProduit(new Produit(idProduit));
		f.setUser(new User(idUser));
		return favorisRepository.save(f);
	}

	@Override
	public void deleteFav(long idFavoris) {
		favorisRepository.deleteById(idFavoris);
		
	}

	@Override
	public Favoris findByIdProduitIdUser(long idProduit, long idUser) {
		
		return favorisRepository.findByIdProduitIdUser(idProduit, idUser);
	}

/*	@Override
	public List retriveAllFav(long idUser) {	
		return favorisRepository.retriveAllFav(idUser);
	}

	@Override
	public Favoris addFav(Favoris f , long idProduit, long idUser) {
		Favoris fav1 = favorisRepository.findFavByIdClient(idUser);
		if(fav1==null) {
			Favoris fav = favorisRepository.save(f);
			favorisRepository.addFavProd(fav.getIdFavoris(), idProduit);
			return fav;
		}
		else {
			favorisRepository.addFavProd(fav1.getIdFavoris(), idProduit);
			return fav1;
		}
		
	}

	@Override
	public void deleteFav(long idProduit) {
		
		
	}
*/
}