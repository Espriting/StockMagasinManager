package tn.magasin.stock.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.magasin.stock.Service.FavorisService;
import tn.magasin.stock.entity.Favoris;
import tn.magasin.stock.entity.Produit;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/favoris")
public class FavorisRestController {

	@Autowired
	FavorisService fs;

	@GetMapping("/display/{idUser}")
	public List<Object[]> retriveAllFav(@PathVariable(value="idUser") long idUser) {

		return fs.retriveAllFav(idUser);
	}

	@PostMapping("/add/{idProduit}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Favoris addFav(@Valid @RequestBody Favoris f,@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idUser") long idUser) {
		return fs.addFav(f,idProduit,idUser);
	}

	@DeleteMapping("/delete/{idFavoris}")
	public void deleteFav(@PathVariable(value="idFavoris") long idFavoris) {
		fs.deleteFav(idFavoris);

	}

	@GetMapping("/findFav/{idProduit}/{idUser}")
	public Favoris findByIdProduitIdUser(@PathVariable(value="idProduit") long idProduit,@PathVariable(value="idUser") long idUser) {

		return fs.findByIdProduitIdUser(idProduit, idUser);
	}

}
