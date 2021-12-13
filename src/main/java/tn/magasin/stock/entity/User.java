package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.magasin.stock.enumeration.CategorieClient;


@ToString
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="User")
public class User implements Serializable {

	/**
	 *
	 */
	/*@OneToMany(mappedBy = "user")
	private Set<Feedback> feedback;*/


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private String email;
	private String password;
	@Enumerated(EnumType.ORDINAL)
	private CategorieClient categorie;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Favoris> favoris;

	public User(Long id) {
		this.id = id;
	}
}