package tn.magasin.stock.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	@Query("SELECT f  FROM Feedback f WHERE f.produit.idProduit = :idProduit ")
	List<Feedback> findAllByIdProduit(@Param("idProduit") long idProduit);
	
	@Query(value="SELECT *  FROM Feedback f WHERE f.produit_id_produit = :idProduit AND commentaire IS NOT NULL",
			nativeQuery = true)
	List<Feedback> getAllComments(@Param("idProduit") long idProduit);
	
	@Query("SELECT f FROM Feedback f WHERE f.user.id = :id AND f.produit.idProduit = :idProduit AND (f.reaction='Like' OR f.reaction='Dislike') ")
	List<Feedback> checkReaction(@Param("id") long id, @Param("idProduit") long idProduit);
	
	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.produit.idProduit = :idProduit AND f.reaction='Like' ")
	long nbrLikes(@Param("idProduit") long idProduit);
	
	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.produit.idProduit = :idProduit AND f.reaction='Dislike' ")
	long nbrDislikes(@Param("idProduit") long idProduit);
	
	@Query("SELECT f FROM Feedback f WHERE f.idFeedback = :idFeedback ")
	Optional<Feedback> findFeedbackById(@Param("idFeedback") long idFeedback);
	

	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET categorieclient = 'Blocked' WHERE (id IN (SELECT user_id FROM `feedback` WHERE (commentaire LIKE \\\"%ban%\\\") OR (commentaire LIKE \\\"%ban1\\\"))) AND role='CLIENT'" , nativeQuery = true)
	void banAccount(); 
	
}
