package tn.magasin.stock.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import tn.magasin.stock.enumeration.CategorieClient;
import tn.magasin.stock.enumeration.CategorieProduit;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable{
	/**
	 * 
	 */
	@ManyToOne
	private Stock stock;
	@ManyToMany( cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	@ManyToOne(cascade = CascadeType.ALL)
	private Rayon rayon;
	@ManyToOne(cascade = CascadeType.ALL)
	private DetailFacture detailFacture;
	@OneToOne
	private DetailProduit detailProduit;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "produit")
	private Set<Feedback> feedback; 
	
	
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
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
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
	public DetailProduit getDetailProduit() {
		return detailProduit;
	}
	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}
	public Set<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
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
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	public Produit() {
		super();
	}
	public Produit(Set<Feedback> feedback, Long idProduit, String code, String libelle, float prixUnitaire,
			CategorieProduit categorieProduit) {
		super();
		this.feedback = feedback;
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
	}
	
	public Produit(Long idProduit, String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit) {
		super();
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
	}
	
	public Produit(String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
	}
	
	public Produit(Long idProduit) {
		super();
		this.idProduit = idProduit;
	}
	@Override
	public String toString() {
		return "Produit [ idProduit="
				+ idProduit + ", code=" + code + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire
				+ ", categorieProduit=" + categorieProduit + "]";
	}
	
	
	
	

	
}
