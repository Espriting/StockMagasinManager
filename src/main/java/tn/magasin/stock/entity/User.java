package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import tn.magasin.stock.enumeration.CategorieClient;
import tn.magasin.stock.enumeration.Profession;
import tn.magasin.stock.enumeration.Role;


@Entity
@Table(name="User")
public class User implements Serializable {

	/**
	 * 
	 */
	@OneToMany(mappedBy = "user")
	private Set<Feedback> feedback;
	@OneToMany(mappedBy = "user")
	private Set<Facture> facture;

	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "dateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "categorieclient")
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
	@Column(name = "profession")
	@Enumerated(EnumType.STRING)
	private Profession profession;
	@Enumerated(EnumType.STRING)
	private Role role;

	
	
	public User(Long id, String nom, String prenom, Date dateNaissance, String email, String password, CategorieClient categorieClient, Profession profession, Role role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.categorieClient = categorieClient;
		this.profession = profession;
		this.role = role;
	}

	public User() {
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CategorieClient getCategorieClient() {
		return categorieClient;
	}

	public void setCategorieClient(CategorieClient categorieClient) {
		this.categorieClient = categorieClient;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

	public Set<Facture> getFacture() {
		return facture;
	}

	public void setFacture(Set<Facture> facture) {
		this.facture = facture;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", password=" + password + ", categorieClient=" + categorieClient
				+ ", profession=" + profession + ", role=" + role + "]";
	}

	
	
}
