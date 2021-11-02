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
	@Column(name = "upLike")
	private String upLike;
	@Column(name = "downdLike")
	private String downLike;

	

}
