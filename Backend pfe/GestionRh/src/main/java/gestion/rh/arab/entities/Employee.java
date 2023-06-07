package gestion.rh.arab.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer id;

	private String firstname;
	private String matricule;

	private String email;

	private String password;

	private String lastname;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "departement_id")
    private Departement departement;
	private Integer numerotelephone;
	
	private Integer salaire;
	private Integer congeDuration;
	private Integer SoldeCongee;
	private Integer totalLeaveEntitlement;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Integer getNumerotelephone() {
		return numerotelephone;
	}
	public void setNumerotelephone(Integer numerotelephone) {
		this.numerotelephone = numerotelephone;
	}
	public Integer getSalaire() {
		return salaire;
	}
	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}
	public Integer getCongeDuration() {
		return congeDuration;
	}
	public void setCongeDuration(Integer congeDuration) {
		this.congeDuration = congeDuration;
	}
	public Integer getSoldeCongee() {
		return SoldeCongee;
	}
	public void setSoldeCongee(Integer soldeCongee) {
		SoldeCongee = soldeCongee;
	}
	public Integer getTotalLeaveEntitlement() {
		return totalLeaveEntitlement;
	}
	public void setTotalLeaveEntitlement(Integer totalLeaveEntitlement) {
		this.totalLeaveEntitlement = totalLeaveEntitlement;
	}
	 
		// TODO Auto-generated method stub
		
	
	

}
