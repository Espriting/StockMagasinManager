package tn.magasin.stock.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Livreur")
@PrimaryKeyJoinColumn(name="id")
public class Livreur extends User implements Serializable{

}
