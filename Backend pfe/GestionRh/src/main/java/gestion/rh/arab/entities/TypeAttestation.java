package gestion.rh.arab.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TypeAttestation {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	private String nom;
	public TypeAttestation() {
		super();
	}
	public TypeAttestation(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
