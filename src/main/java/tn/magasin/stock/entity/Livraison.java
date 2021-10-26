package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Livraison")
public class Livraison  implements Serializable{
	@ManyToOne(cascade = CascadeType.ALL )
	private User user;
	@OneToMany(cascade = CascadeType.ALL ,  mappedBy = "livraison")
	private Set<Commande> commandes;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLivraison")
	private Long idLivraison;
	@Column(name = "adressse")
	private String adressse;
	@Column(name = "etat")
	private Boolean etat;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Long getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(Long idLivraison) {
		this.idLivraison = idLivraison;
	}
	public String getAdressse() {
		return adressse;
	}
	public void setAdressse(String adressse) {
		this.adressse = adressse;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Livraison(Long idLivraison, String adressse, Boolean etat, Date date) {
		super();
		this.idLivraison = idLivraison;
		this.adressse = adressse;
		this.etat = etat;
		this.date = date;
	}
	public Livraison() {
		super();
	}
}
