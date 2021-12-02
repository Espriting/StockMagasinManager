package tn.magasin.stock.Controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.magasin.stock.Service.FeedbackService;
import tn.magasin.stock.Service.ProduitService;
import tn.magasin.stock.entity.Feedback;
import tn.magasin.stock.entity.Produit;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedback")
public class FeedbackRestController {


	@Autowired
	FeedbackService fs;


	@GetMapping("/display/{idProduit}")
	public List<Feedback> getFeedbacks(@PathVariable(value = "idProduit") Long idProduit) {
		List<Feedback> listFeedbacks = fs.retrieveAllFeedbacks(idProduit);
		return listFeedbacks;
	}

	@PostMapping("/addComment/{idProduit}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addCommentire(@Valid @RequestBody Feedback f,@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idUser") long idUser) {
		Feedback f1 = fs.addComment(f,idProduit,idUser);
		return f1;
	}


	@DeleteMapping("/delete/{idFeedback}")
	public void deleteFeedbacks(@PathVariable(value = "idFeedback") Long idFeedback) throws NoSuchElementException {
		fs.deleteFeedback(idFeedback);

	}


	@PutMapping("/updateComment/{idFeedback}")
	public Feedback updateCommentaire(@PathVariable(value = "idFeedback") Long idFeedback, @Valid @RequestBody Feedback f) {
		Feedback f1 = fs.updateComment(idFeedback, f);
		return f1;
	}



	@PostMapping("/addReaction/{idProduit}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addReactions(@Valid @RequestBody Feedback f,@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idUser") long idUser) {
		Feedback f1 = fs.addReaction(f,idProduit,idUser);
		return f1;

	}


	@PutMapping("/updateReaction/{idFeedback}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback updateReactions(@PathVariable(value = "idFeedback") Long idFeedback, @Valid @RequestBody Feedback f) {
		Feedback f1 = fs.updateReaction(idFeedback, f);
		return f1;
	}


	@GetMapping("/search/{idFeedback}")
	public Feedback retrieveFeedback(@PathVariable(value = "idFeedback") Long idFeedback) throws NoSuchElementException {
		Feedback f = fs.retrieveFeedback(idFeedback);
		return f ;
	}


	@GetMapping("/nbrLike/{idProduit}")
	public long nbrLike(@PathVariable(value = "idProduit") long idProduit) {
		long likes = fs.nbrLikes(idProduit);
		return likes;
	}


	@GetMapping("/nbrDislike/{idProduit}")
	public long nbrDislike(@PathVariable(value = "idProduit") long idProduit) {
		long dislikes = fs.nbrDislikes(idProduit);
		return dislikes;
	}

	@PutMapping("/ban")
	public void banAccountC() {
		fs.banAccount();
	}

	@GetMapping("comments/{idProduit}")
	public List<Feedback> retreiveComments(@PathVariable(value = "idProduit") Long idProduit) {

		return fs.retreiveComments(idProduit);
	}


}
