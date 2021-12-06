package tn.magasin.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Livraison")
public class Livraison  implements Serializable{
	@ManyToOne(cascade = CascadeType.ALL )
	@JsonIgnore
	private User user;
	@OneToOne(cascade = CascadeType.ALL)
	private Commande commande;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLivraison")
	private Long idLivraison;
	@Column(name = "adressse")
	private String adressse;
	@Column(name = "etat")
	private Boolean etat;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Livraison(User user, String adressse, Boolean etat, Date date) {
		this.user = user;
		this.adressse = adressse;
		this.etat = etat;
		this.date = date;
	}

	public Livraison(String adressse, Boolean etat, Date date) {

		this.adressse = adressse;
		this.etat = etat;
		this.date = date;
	}

	public Livraison(Long idLivraison, String adressse, Boolean etat, Date date) {
		this.idLivraison = idLivraison;
		this.adressse = adressse;
		this.etat = etat;
		this.date = date;
	}



	public Livraison(Long idLivraison) {
		this.idLivraison = idLivraison;
	}
}
