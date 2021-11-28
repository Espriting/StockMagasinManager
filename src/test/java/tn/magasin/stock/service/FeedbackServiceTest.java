package tn.magasin.stock.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	void addReactionTest() throws NoSuchElementException {

		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setReaction("Like");
		f.setProduit(new Produit(50L));
		f.setUser(new User(50L));

		List<Feedback> list = new ArrayList<>();
		list.add(f);
		List<Feedback> fergha = new ArrayList<>();
		Mockito.when(feedbackRepository.checkReaction((long) 50,(long) 50)).thenReturn(list);
		if((feedbackRepository.checkReaction((long) 50,(long) 50)).isEmpty()) {
			System.out.println("if");

			Mockito.when(feedbackRepository.save(f)).thenReturn(f) ;
			Feedback f1 = fs.addReaction(f);
			assertThat(f).isEqualTo(f1);

			l.info(f.toString());

		}else {
			System.out.println("else");
			Feedback newf = new Feedback();
			newf.setIdFeedback(f.getIdFeedback());
			newf.setReaction("Dislike");
			newf.setProduit(new Produit(50L));
			newf.setUser(new User(50L));
			Mockito.when(feedbackRepository.findById(f.getIdFeedback())).thenReturn(Optional.of(f)); 
			fs.updateReaction(f.getIdFeedback() ,newf);
			assertEquals(f.getIdFeedback(), newf.getIdFeedback());
			assertEquals(f.getReaction(), newf.getReaction());
			assertEquals(f.getProduit().getIdProduit(), newf.getProduit().getIdProduit());
			assertEquals(f.getUser().getId(), newf.getUser().getId());

			l.info(newf.toString());
		}

	}

	@Test 
	void deleteFeedbackTest() {
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setCommentaire("cmnt");
		f.setReaction("like");
		f.setProduit(new Produit(50L));
		f.setUser(new User(50L));
		Mockito.when(feedbackRepository.findById(f.getIdFeedback())).thenReturn(null);
		fs.deleteFeedback(f.getIdFeedback());
		assertThat(feedbackRepository.findById(f.getIdFeedback())).isEqualTo(null);
		l.info("Produit suprime!!");
	}


	@Test
	void nbrLikesTest() {
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setReaction("Like");
		f.setProduit(new Produit(50L));
		f.setUser(new User(50L));

		Feedback f1 = new Feedback();
		f1.setIdFeedback(50L);
		f1.setReaction("Like");
		f1.setProduit(new Produit(50L));
		f1.setUser(new User(51L));
		Mockito.when(feedbackRepository.nbrLikes(f.getProduit().getIdProduit())).thenReturn(2L);
		long nbrLike = fs.nbrLikes(f.getProduit().getIdProduit());
		assertThat(feedbackRepository.nbrLikes(f.getProduit().getIdProduit())).isEqualTo(nbrLike);
		l.info(""+nbrLike);
	}

	@Test
	void nbrDislLikesTest() {
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setReaction("Dislike");
		f.setProduit(new Produit(50L));
		f.setUser(new User(50L));

		Feedback f1 = new Feedback();
		f1.setIdFeedback(50L);
		f1.setReaction("Dislike");
		f1.setProduit(new Produit(50L));
		f1.setUser(new User(51L));
		Mockito.when(feedbackRepository.nbrDislikes(f.getProduit().getIdProduit())).thenReturn(2L);
		long nbrDislike = fs.nbrDislikes(f.getProduit().getIdProduit());
		l.info(""+nbrDislike);
	}

	@Test 
	void retrieveAllFeedbacksTest() {
		//fs.retrieveAllFeedback((long) 1);
		List<Feedback> feedbacks = new ArrayList<>();
		feedbacks.add(new Feedback(new Produit(50L)));
		feedbacks.add(new Feedback(new Produit(50L)));
		feedbacks.add(new Feedback(new Produit(50L)));
		feedbacks.add(new Feedback(new Produit(51L)));

		List<Feedback> subFeedbacks = feedbacks.subList(0, 3);
		System.out.println(subFeedbacks.size());
		Mockito.when(feedbackRepository.findAllByIdProduit(50L)).thenReturn(subFeedbacks);
		List<Feedback> expected = fs.retrieveAllFeedbacks(50L);
		assertEquals(expected, subFeedbacks);
		assertEquals(3, subFeedbacks.size());
	}


	@Test
	void UpdateCommentTest() { 
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setCommentaire("comment");;
		f.setProduit(new Produit(50L));
		f.setUser(new User(50L));

		Feedback newf = new Feedback();
		newf.setIdFeedback(f.getIdFeedback());
		newf.setCommentaire("NEWcomment");;
		newf.setProduit(new Produit(50L));
		newf.setUser(new User(50L));
		Mockito.when(feedbackRepository.findById(f.getIdFeedback())).thenReturn(Optional.of(f)); 
		fs.updateComment(f.getIdFeedback() ,newf); 
		assertEquals(f.getIdFeedback(), newf.getIdFeedback());
		assertEquals(f.getCommentaire(), newf.getCommentaire());
		assertEquals(f.getProduit().getIdProduit(), newf.getProduit().getIdProduit());
		assertEquals(f.getUser().getId(), newf.getUser().getId());

		l.info("Updated Feedback: " + newf.toString());
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


