package tn.magasin.stock.entity;

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
@Table(name="Facture")
public class Facture implements Serializable {
	/**
	 * 
	 */
	@OneToMany(mappedBy = "factures" , cascade = CascadeType.ALL)
	private Set<Commande> commande;
	@ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	@Column(name="montantRemise")
	private float montantRemise;
	@Column(name="montantFacture")
	private float montantFacture;
	@Column(name="dateFacture")
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	@Column(name="active")
	private boolean active ;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "factures")
	private Set<DetailFacture> detailFactures;


	

}
