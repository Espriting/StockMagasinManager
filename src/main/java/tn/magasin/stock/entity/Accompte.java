package tn.magasin.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Data
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

}
