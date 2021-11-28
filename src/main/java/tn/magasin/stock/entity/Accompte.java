package tn.magasin.stock.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Accompte")
public class Accompte implements Serializable{
	@OneToOne
	private Facture facture;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idAccompte;
	@Column(name = "avance")
	private float avance;
	@Column(name = "montant")
	private float montant;
	@Column(name = "nbrmois")
	private Integer nbrmois;
	public Accompte() {
		super();
	}
	public Accompte(Long idAccompte, float avance, float montant, Integer nbrmois) {
		super();
		this.idAccompte = idAccompte;
		this.avance = avance;
		this.montant = montant;
		this.nbrmois = nbrmois;
	}
	public Long getIdAccompte() {
		return idAccompte;
	}
	public void setIdAccompte(Long idAccompte) {
		this.idAccompte = idAccompte;
	}
	public float getAvance() {
		return avance;
	}
	public void setAvance(float avance) {
		this.avance = avance;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Integer getNbrmois() {
		return nbrmois;
	}
	public void setNbrmois(Integer nbrmois) {
		this.nbrmois = nbrmois;
	}
	
}
