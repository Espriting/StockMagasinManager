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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idAccompte;
	@Column(name = "advance")
	private double advance;
	@Column(name = "price")
	private double price;
	@Column(name = "norms")
	private Integer norms;
	@Column(name = "nom")
	private String nom;

}
