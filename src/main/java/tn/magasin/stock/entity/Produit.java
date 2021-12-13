package tn.magasin.stock.entity;


import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.magasin.stock.enumeration.CategorieClient;
import tn.magasin.stock.enumeration.CategorieProduit;


@Entity
@Table(name = "Produit")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder



public class Produit implements Serializable{

	@JsonIgnore
	@ManyToOne( cascade = CascadeType.ALL)
	@ToString.Exclude private Stock stock;
	
	@JsonIgnore
	@ManyToMany( cascade = CascadeType.ALL)
	@ToString.Exclude private Set<Fournisseur> fournisseurs;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@ToString.Exclude private Rayon rayon;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@ToString.Exclude private DetailFacture detailFacture;
	
	@JsonIgnore
	@OneToOne
	@ToString.Exclude private DetailProduit detailProduit;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "produit")
	@ToString.Exclude private Set<Feedback> feedback; 
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "produit")
	@ToString.Exclude private List<Favoris> favoris; 
	
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreation")
	private Date dateCreation;
	
	@Column(name = "picture")
	private String picture;
	
	
	
	
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

	public Produit(String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit,
			Date dateCreation, String picture) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
		this.dateCreation = dateCreation;
		this.picture = picture;
	}

	
	
	
	
	

	
}
