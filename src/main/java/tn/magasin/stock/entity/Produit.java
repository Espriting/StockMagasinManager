package tn.magasin.stock.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

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

	@OneToOne
	private DetailProduit detailProduit;
	/*@ManyToOne(cascade = CascadeType.ALL)
	private DetailFacture detailFacture;*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private Long idClient ; //clé primaire
	@Column(name = "code")
	private String code;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "prixUnitaire")
	private float prixUnitaire;
	public Produit(Long idClient, String code, String libelle, float prixUnitaire) {
		super();
		this.idClient = idClient;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}
	public Produit(String code, String libelle, float prixUnitaire) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}
	public Produit() {
		super();
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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
	
	
}
