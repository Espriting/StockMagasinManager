package tn.magasin.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

	public Commande(Facture factures, Livraison livraison, Date dateCommande) {
		this.factures = factures;
		this.livraison = livraison;
		this.dateCommande = dateCommande;
	}

	public Commande(Long idCommande, Date dateCommande) {
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Commande(Facture factures, Long idCommande, Date dateCommande) {
		this.factures = factures;
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Commande(Livraison livraison, Long idCommande, Date dateCommande) {
		this.livraison = livraison;
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}
}
