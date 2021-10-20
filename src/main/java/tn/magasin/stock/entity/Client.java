package tn.magasin.stock.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import tn.magasin.stock.enumeration.CategorieClient;
import tn.magasin.stock.enumeration.Profession;
@Entity
@Table(name="Client")
@PrimaryKeyJoinColumn(name="id")
public class Client extends User implements Serializable {
	
	@Column(name = "categorieclient")
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
	@Column(name = "profession")
	@Enumerated(EnumType.STRING)
	private Profession profession;
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
	public Client(Long idClient, String nom, String prenom, Date dateNaissance, String email, String password,
			CategorieClient categorieClient, Profession profession, CategorieClient categorieClient2,
			Profession profession2) {
		super(idClient, nom, prenom, dateNaissance, email, password, categorieClient, profession);
		categorieClient = categorieClient2;
		profession = profession2;
	}
	public Client(Long idClient, String nom, String prenom, Date dateNaissance, String email, String password,
			CategorieClient categorieClient, Profession profession) {
		super(idClient, nom, prenom, dateNaissance, email, password, categorieClient, profession);
	}
	
}
