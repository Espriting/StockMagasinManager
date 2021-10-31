package tn.magasin.stock.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.magasin.stock.entity.Feedback;
import tn.magasin.stock.entity.Produit;
import tn.magasin.stock.entity.User;
import tn.magasin.stock.enumeration.CategorieProduit;
import tn.magasin.stock.Repository.FeedbackRepository;
import tn.magasin.stock.Repository.ProduitRepository;
import tn.magasin.stock.Service.FeedbackService;
import tn.magasin.stock.Service.ProduitService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class FeedbackServiceTest {


	private static final Logger l = LogManager.getLogger(FeedbackServiceTest.class);

	@Mock
	private FeedbackRepository feedbackRepository;

	@InjectMocks
	private FeedbackService fs;



	@Test
	void addCommentTest() {

		Feedback f = new Feedback(new User(20L),new Produit(10L),"commenttest");
		Mockito.when(feedbackRepository.save(f)).thenReturn(f);
		Feedback f1 = fs.addComment(f);
		l.info(f);
		l.info(f1);
		assertThat(f).isEqualTo(f1);
	}


	@Test
	void addReactionTest() {

		Feedback f = new Feedback("Like",new User(20L),new Produit(10L));

		Mockito.when(feedbackRepository.save(f)).thenReturn(f);
		
		Feedback f2 = fs.addReaction(f);
		
		l.info("f="+f);
		l.info("f2="+f2);
		
		assertThat(f).isEqualTo(f2);
	}

























	//@Autowired
	//private FeedbackService fs;
	//@Autowired
	//private FeedbackRepository feedbackRepository;
	/*
	@Test
	void addCommentTest() {

		Feedback f = new Feedback(50L ,new User(20L),new Produit(10L),"CommentTest");
		Mockito.when(feedbackRepository.save(f)).thenReturn(f);
		Feedback f1 = fs.addComment(f);
		assertThat(f).isEqualTo(f1);
	}

	@Test
	void addCommentTest() {

		Feedback f = new Feedback(50L ,new User(20L),new Produit(10L),"CommentTest");
		Mockito.when(feedbackRepository.save(f)).thenReturn(f);
		Feedback f1 = fs.addComment(f);
		assertThat(f).isEqualTo(f1);
	}

	@Test
	void addCommentTest() {

		Feedback f = new Feedback(50L ,new User(20L),new Produit(10L),"CommentTest");
		Mockito.when(feedbackRepository.save(f)).thenReturn(f);
		Feedback f1 = fs.addComment(f);
		assertThat(f).isEqualTo(f1);
	}


	@Test
	void addCommentTest() throws ParseException {
		User u = new User((long) 2);
		Feedback f1 = new Feedback();
		//Long u1 = u.setId(null);

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

		Feedback f = new Feedback("Like",u,new Produit((long) 3));

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
	void addReactionTest() throws NoSuchElementException {
		User u = new User((long) 2);

		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************Ajout Commentaire*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");

		//Feedback f = new Feedback("Dislike",u,new Produit((long) 3));
		System.out.println(feedbackRepository.checkReaction((long) 2,(long) 6));
		if((feedbackRepository.checkReaction((long) 2,(long) 6)).isEmpty()) {

			Feedback f = new Feedback("Dislike",u,new Produit((long) 6));
			feedbackRepository.save(f);
			l.info(f);

		}else {
			//Feedback f1 = fs.retrieveFeedback((long) 1); 
			Feedback f1 = feedbackRepository.findById((long) 3).orElseThrow(() -> new NoSuchElementException("Feedback not found for this id :: " + 1)) ;
			f1.setReaction("Dislike");
			fs.updateReaction((long) 3, f1);
			l.info(f1);
		}
		//l.info(f1);
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

		long nbrDislike=fs.nbrDislikes(5);
		l.info(nbrDislike);
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************nbr Dislikes affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
	}
	/*
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

	@Test 
	void UpdateCommentTest() { 
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                "); 
		System.out.
		println("*************************Modification du commentaire avec id = "
				+4+" est affiche!*************************");
		System.out.println("                ");
		System.out.println("                ");
		 System.out.println("                "); 
		 Feedback f1 = fs.retrieveFeedback((long) 1); 
		 f1.setCommentaire("testUpdated222");

		 fs.updateComment((long)1 ,f1); 
		 l.info("Feedback: " + f1.toString());
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("*************************commentaire avec id = "
				+4+" est modifie!*************************");
		System.out.println("                ");
		System.out.println("                ");
		System.out.println("                "); }



/*
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


	 */

}


