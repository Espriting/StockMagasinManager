package tn.magasin.stock.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.magasin.stock.entity.Feedback;
import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.entity.User;
import tn.magasin.stock.enumeration.CategorieProduit;
import tn.magasin.stock.Repository.ProduitRepository;
import tn.magasin.stock.Service.FeedbackService;
import tn.magasin.stock.Service.ProduitService;

@RunWith(SpringRunner.class)
@SpringBootTest
class FeedbackServiceTest {


	private static final Logger l = LogManager.getLogger(FeedbackServiceTest.class);

	@Autowired
	private FeedbackService fs;




	@Test
	void addCommentTest() throws ParseException {
		User u = new User((long) 2);

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Ajout Commentaire*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");

		Feedback f = new Feedback(u,new Produit((long) 3),"test");

		fs.addComment(f);
		l.info(f);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Commentaire ajoute!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	} 
	
	@Test
	void addLikeTest() throws ParseException {
		User u = new User((long) 2);

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Ajout Commentaire*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");

		Feedback f = new Feedback(u,new Produit((long) 3),true);

		fs.like(f);
		l.info(f);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Commentaire ajoute!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	} 
	
	@Test
	void addDislikeikeTest() throws ParseException {
		User u = new User((long) 2);

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Ajout Commentaire*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");

		Feedback f = new Feedback(u,true,new Produit((long) 3));

		fs.dislike(f);
		l.info(f);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Commentaire ajoute!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	} 


	@Test
	void nbrLikesTest() throws ParseException {
		//User u = new User((long) 2);

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("************************nbr likes pour produit=3*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");

		//Feedback f = new Feedback(u,true,new Produit((long) 3));

		long nbrLike=fs.nbrLikes(3);
		l.info(nbrLike);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************nbr likes affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	}
	
	@Test
	void nbrDislLikesTest() throws ParseException {
		//User u = new User((long) 2);

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("************************nbr Dislikes pour produit=3*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");

		//Feedback f = new Feedback(u,true,new Produit((long) 3));

		long nbrDislike=fs.nbrDislikes(3);
		l.info(nbrDislike);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************nbr Dislikes affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	}
	
	@Test 
	void retrieveAllFeedbacksTest() {
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                "); System.out.
		println("*************************Liste des feedbacks*************************"
				); System.out.println("                ");
				System.out.println("                ");
				System.out.println("                "); fs.retrieveAllFeedbacks((long) 3);
				System.out.println("                ");
				System.out.println("                ");
				System.out.println("                "); System.out.
				println("*************************Liste des feedbacks affiche!*************************"
						); System.out.println("                ");
						System.out.println("                ");
						System.out.println("                ");

	}



	@Test void retreiveProduitTest() {

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Affichage du produit avec id = "
				+3+" *************************"); System.out.println("                ");
				System.out.println("                ");
				// System.out.println("                "); ps.retrieveProduct((long) 3);
				System.out.println("                ");
				System.out.println("                ");
				System.out.println("                ");
				System.out.println("*************************Produit avec id = "
						+3+" est affiche!*************************");
				System.out.println("                ");
				System.out.println("                ");
				System.out.println("                ");


	}

	@Test void UpdateCommentTest() { 
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                "); 
		System.out.
		println("*************************Modification du commentaire avec id = "
				+4+" est affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		 System.out.println("                "); 
		 Feedback f1 = fs.retrieveFeedback((long) 4); 
		 f1.setCommentaire("testUpdated222");
		  
		 fs.updateComment((long)4 ,f1); 
		 l.info("Feedback: " + f1.toString());
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************commentaire avec id = "
				+4+" est modifie!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                "); }

	
	
	
	@Test void deleteFeedbackTest() { System.out.println("                ");
	System.out.println("                ");
	System.out.println("                "); System.out.
	println("*************************Suppression du produit avec id = "
			+4+" est affiche!*************************");
	System.out.println("                ");
	System.out.println("                ");
	System.out.println("                "); fs.deleteFeedback((long) 6);
	l.info("Produit suprime!!"); System.out.println("                ");
	System.out.println("                ");
	System.out.println("                ");
	System.out.println("*************************Produit avec id = "
			+4+" est supprime!*************************");
	System.out.println("                ");
	System.out.println("                ");
	System.out.println("                "); }



}