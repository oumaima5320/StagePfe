package gestion.rh.arab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

public class Autorisation implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Jourdautorisation;
	private String Heuredebut;
	private String Heurefin;
	private String description;
	@ManyToOne @JoinColumn(name="user_id")
	private User user;
	private String reponserh;
	private String fonction;
	private String service;
	private String nomprenom;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJourdautorisation() {
		return Jourdautorisation;
	}
	public void setJourdautorisation(String jourdautorisation) {
		Jourdautorisation = jourdautorisation;
	}
	public String getHeuredebut() {
		return Heuredebut;
	}
	public void setHeuredebut(String heuredebut) {
		Heuredebut = heuredebut;
	}
	public String getHeurefin() {
		return Heurefin;
	}
	public void setHeurefin(String heurefin) {
		Heurefin = heurefin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReponserh() {
		return reponserh;
	}
	public void setReponserh(String reponserh) {
		this.reponserh = reponserh;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNomprenom() {
		return nomprenom;
	}
	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}
	
	

}



