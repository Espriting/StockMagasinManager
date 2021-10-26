package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback  implements Serializable{
	@ManyToOne
	private User user;
	@ManyToOne
	private Produit produit;
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFeedback")
	private Long idFeedback;
	@Column(name = "commentaire")
	private String commentaire;
	@Column(name = "liked")
	private Boolean liked;
	@Column(name = "disliked")
	private Boolean disliked;
	
	
	
	
	public Feedback() {
		super();
	}
	
	
	
	public Feedback(User user, Boolean disliked, Produit produit) {
		super();
		this.user = user;
		this.disliked = disliked;
		this.produit = produit;
		
	}



	public Feedback(User user, Produit produit, Boolean liked) {
		super();
		this.user = user;
		this.produit = produit;
		this.liked = liked;
	}



	public Feedback(User user, Produit produit, String commentaire) {
		super();
		this.user = user;
		this.produit = produit;
		this.commentaire = commentaire;
	}



	public Feedback(User user, Produit produit, String commentaire, Boolean liked, Boolean disliked) {
		super();
		this.user = user;
		this.produit = produit;
		this.commentaire = commentaire;
		this.liked = liked;
		this.disliked = disliked;
	}



	public Feedback(User user, Produit produit, Long idFeedback, String commentaire, Boolean liked, Boolean disliked) {
		super();
		this.user = user;
		this.produit = produit;
		this.idFeedback = idFeedback;
		this.commentaire = commentaire;
		this.liked = liked;
		this.disliked = disliked;
	}



	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Long getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(Long idFeedback) {
		this.idFeedback = idFeedback;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Boolean isLike() {
		return liked;
	}
	public void setLike(Boolean liked) {
		this.liked = liked;
	}
	public Boolean isDislike() {
		return disliked;
	}
	public void setDislike(Boolean disliked) {
		this.disliked = disliked;
	}



	@Override
	public String toString() {
		return "Feedback [user=" + user + ", produit=" + produit + ", idFeedback=" + idFeedback + ", commentaire="
				+ commentaire + ", liked=" + liked + ", disliked=" + disliked + "]";
	}

	
	
}
