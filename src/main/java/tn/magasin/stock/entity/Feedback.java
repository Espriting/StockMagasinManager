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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.magasin.stock.enumeration.CategorieProduit;

@Entity
@Table(name = "Feedback")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


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
	@Column(name = "reaction")
	private String reaction;
	
	
	
	
	
	

	public Feedback(User user, Produit produit, String commentaire) {
		super();
		this.user = user;
		this.produit = produit;
		this.commentaire = commentaire;
	}



	public Feedback(User user, Produit produit, String commentaire, String reaction) {
		super();
		this.user = user;
		this.produit = produit;
		this.commentaire = commentaire;
		this.reaction = reaction;
	}



	public Feedback(Long idFeedback,User user, Produit produit,  String commentaire) {
		super();
		this.idFeedback = idFeedback;
		this.user = user;
		this.produit = produit;
		
		this.commentaire = commentaire;
	}



	public Feedback(String reaction, User user, Produit produit) {
		super();
		this.reaction = reaction;
		this.user = user;
		this.produit = produit;
		
	}



	

	



	
	
}
