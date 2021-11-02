package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Stock")
public class Stock implements Serializable{
	/**
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "stock")
	private Set<Produit> produit;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStock")
	private Long idStock ;
	@Column(name = "qte")
	private int qte;
	@Column(name = "qteMin")
	private int qteMin;
	@Column(name = "libelleStock")
	private String libelleStock;
	
}
