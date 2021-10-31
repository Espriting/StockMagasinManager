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
@Table(name="Commande")
public class Commande implements Serializable{
	@ManyToOne( cascade = CascadeType.ALL)
	private Facture factures;
	@ManyToOne(cascade = CascadeType.ALL)
	private Livraison livraison;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCommande")
	private Long idCommande;
	@Column(name = "dateCommande")
	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	@Column(name = "etat")
	private Boolean etat;
	public Commande(Long idCommande, Date dateCommande, Boolean etat) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.etat = etat;
	}
	public Commande() {
		super();
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Facture getFactures() {
		return factures;
	}

	public void setFactures(Facture factures) {
		this.factures = factures;
	}
}
