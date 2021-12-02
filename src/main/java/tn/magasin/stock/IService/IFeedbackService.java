package tn.magasin.stock.IService;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import tn.magasin.stock.entity.Feedback;

public interface IFeedbackService {
	
	List<Feedback> retrieveAllFeedbacks(Long idProduit);
	
	List<Feedback> retreiveComments(Long idProduit);

	Feedback addComment(Feedback f, long idProduit, long idUser);

	void deleteFeedback(Long idFeedback);

	Feedback updateComment(Long idFeedback ,Feedback f);
	
	Feedback addReaction(Feedback f, long idProduit, long idUser);
	
	Feedback updateReaction(Long idFeedback,Feedback f);

	Feedback retrieveFeedback(Long idFeedback);
	
	long nbrLikes(long idProduit);
	
	long nbrDislikes(long idProduit);
	
	void banAccount(); 

}
