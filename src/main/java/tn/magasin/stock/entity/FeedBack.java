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
import javax.persistence.Table;

@Entity
@Table(name = "FeedBack")
public class FeedBack  implements Serializable{
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> users;
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFeedBack")
	private Long idFeedBack;
	@Column(name = "commentaire")
	private String commentaire;
	@Column(name = "like")
	private String like;
	@Column(name = "dislike")
	private String dislike;

	public FeedBack(Long idFeedBack, String commentaire, String like, String dislike) {
		super();
		this.idFeedBack = idFeedBack;
		this.commentaire = commentaire;
		this.like = like;
		this.dislike = dislike;
	}

	public FeedBack() {
		super();
	}

	public Long getIdFeedBack() {
		return idFeedBack;
	}

	public void setIdFeedBack(Long idFeedBack) {
		this.idFeedBack = idFeedBack;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getDislike() {
		return dislike;
	}

	public void setDislike(String dislike) {
		this.dislike = dislike;
	}
}
