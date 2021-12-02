package tn.magasin.stock.Service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.magasin.stock.IService.IFeedbackService;
import tn.magasin.stock.Repository.FeedbackRepository;
import tn.magasin.stock.Repository.ProduitRepository;
import tn.magasin.stock.entity.Feedback;
import tn.magasin.stock.entity.Produit;

@Service
public class FeedbackService implements IFeedbackService{

    @Autowired
    FeedbackRepository feedbackRepository;

    private static final Logger l = LogManager.getLogger(ProduitService.class);


    @Override
    public List<Feedback> retrieveAllFeedbacks(@PathVariable(value = "idProduit") Long idProduit) {
        List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAllByIdProduit(idProduit);
        //System.out.println(feedbacks);
        for(Feedback feedback : feedbacks) {
            l.info("Feedback: "+ feedback);
        }

        return feedbacks;
    }


    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public Feedback addComment(@Valid @RequestBody Feedback c) {
        return feedbackRepository.save(c);
    }


    @Override
    public void deleteFeedback(@PathVariable(value = "idFeedback") Long idFeedback) throws NoSuchElementException {
        feedbackRepository.deleteById(idFeedback);

    }

    @Override
    public Feedback updateComment(@PathVariable(value = "idFeedback") Long idFeedback, @Valid @RequestBody Feedback f) {
        Feedback f1 = retrieveFeedback(idFeedback);

        f1.setCommentaire(f.getCommentaire());


        return feedbackRepository.save(f1);
    }


    @Override
    public Feedback addReaction(@Valid @RequestBody Feedback f) {

        return feedbackRepository.save(f);

    }

    @Override
    public Feedback updateReaction(@PathVariable(value = "idFeedback") Long idFeedback, @Valid @RequestBody Feedback f) {
        //System.out.println(feedbackRepository.checkReaction((long) 2,(long) 3));

        Feedback f1 = retrieveFeedback(idFeedback);
        f1.setReaction(f.getReaction());

        //f.setCommentaire(null);
        return feedbackRepository.save(f1);
    }




    @Override
    public Feedback retrieveFeedback(@PathVariable(value = "idFeedback") Long idFeedback) throws NoSuchElementException {
        Feedback f = feedbackRepository.findById(idFeedback).orElseThrow(() -> new NoSuchElementException(" not found for this id :: " + idFeedback)) ;
        l.info("Feedback: "+ f);
        return f ;
    }


    @Override
    public long nbrLikes(@PathVariable(value = "idProduit") long idProduit) {
        long likes = (long) feedbackRepository.nbrLikes(idProduit);
        l.info("Likes: "+ likes);
        return (long) likes;
    }

    @Override
    public long nbrDislikes(@PathVariable(value = "idProduit") long idProduit) {
        long dislikes = (long) feedbackRepository.nbrDislikes(idProduit);
        l.info("dislikes: "+ dislikes);
        return (long) dislikes;
    }



    @Override
    public void banAccount() {
        feedbackRepository.banAccount();
    }




}