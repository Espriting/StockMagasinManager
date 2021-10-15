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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private Long idProduit ; //clé primaire
	@Column(name = "code")
	private String code;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "prixUnitaire")
	private float prixUnitaire;
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToOne
	private Stock stock;
	@ManyToMany( cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseur;
	@ManyToOne(cascade = CascadeType.ALL)
	private Rayon rayon;
	@ManyToOne(cascade = CascadeType.ALL)
	private DetailFacture detailFacture;
	public Produit() {
		super();
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public DetailProduit getDetailProduit() {
		return detailProduit;
	}
	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Set<Fournisseur> getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Set<Fournisseur> fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Rayon getRayon() {
		return rayon;
	}
	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
	public DetailFacture getDetailFacture() {
		return detailFacture;
	}
	public void setDetailFacture(DetailFacture detailFacture) {
		this.detailFacture = detailFacture;
	}
	
	
	
	
}
