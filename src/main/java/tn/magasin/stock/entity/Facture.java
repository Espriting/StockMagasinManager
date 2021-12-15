package tn.magasin.stock.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Data
@Entity
public class Facture implements Serializable {
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private boolean active ;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private float montantFacture;
	private float montantRemise;



	@OneToMany(cascade = CascadeType.ALL,mappedBy = "factures")
	@JsonIgnore
	private Set<DetailFacture> detailFactures;
	@OneToMany(mappedBy = "factures" , cascade = CascadeType.ALL)
	private Set<Commande> commande;
	@ManyToOne
	private User user;



}
