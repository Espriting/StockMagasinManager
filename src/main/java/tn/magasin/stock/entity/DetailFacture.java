package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DetailFacture")
public class DetailFacture implements Serializable {
	/**
	 * 
	 */
	@ManyToOne
	private Facture factures;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Produit> produits;
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailFacture")
	private Long idDetailFacture;

	public Facture getFactures() {
		return factures;
	}

	public void setFactures(Facture factures) {
		this.factures = factures;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	@Column(name = "qte")
	private int qte;
	@Column(name = "prixTotal")
	private float prixTotal;
	@Column(name = "pourcentageRemise")
	private int pourcentageRemise;
	@Column(name = "montantRemise")
	private float montantRemise;
	
	
	
	
	@ManyToOne
	Facture facture;
	
	
	
	public DetailFacture(Long idDetailFacture, int qte, float prixTotal, int pourcentageRemise, float montantRemise) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}
	public DetailFacture(int qte, float prixTotal, int pourcentageRemise, float montantRemise) {
		super();
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}
	public DetailFacture() {
		super();
	}
	public Long getIdDetailFacture() {
		return idDetailFacture;
	}
	public void setIdDetailFacture(Long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public float getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}
	public int getPourcentageRemise() {
		return pourcentageRemise;
	}
	public void setPourcentageRemise(int pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}
	public float getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}
	

}
