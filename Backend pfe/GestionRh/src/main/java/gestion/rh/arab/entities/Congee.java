package gestion.rh.arab.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Congee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String premierjour;
	private String dernierjour;
    private String Heuredebut;
    private String Heurefin;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String reponserh;
    private String firstname;
    private String lastname;
    private String typeCongé;
    private String étatDemandeCongé;
    private String motif;
    private Integer congeDuration;
	public Integer getId() {
		return id;
	}
	
	public Employee getEmployee() {
	    return employee;
	}

	public void setEmployee(Employee employee) {
	    this.employee = employee;
	}
	public void setCongeDuration(Integer congeDuration) {
		this.congeDuration = congeDuration;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPremierjour() {
		return premierjour;
	}
	public void setPremierjour(String premierjour) {
		this.premierjour = premierjour;
	}
	public String getDernierjour() {
		return dernierjour;
	}
	public void setDernierjour(String dernierjour) {
		this.dernierjour = dernierjour;
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
	
	public String getReponserh() {
		return reponserh;
	}
	public void setReponserh(String reponserh) {
		this.reponserh = reponserh;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTypeCongé() {
		return typeCongé;
	}
	public void setTypeCongé(String typeCongé) {
		this.typeCongé = typeCongé;
	}
	public String getÉtatDemandeCongé() {
		return étatDemandeCongé;
	}
	public void setÉtatDemandeCongé(String étatDemandeCongé) {
		this.étatDemandeCongé = étatDemandeCongé;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	public Integer getCongeDuration() {
		return congeDuration;
	}
	
	public Congee(Integer id, String premierjour, String dernierjour, String heuredebut, String heurefin, User user,
			String reponserh, String firstname, String lastname, String typeCongé, String étatDemandeCongé,
			String motif, Integer congeDuration, Employee employee ) {
		super();
		this.id = id;
		this.premierjour = premierjour;
		this.dernierjour = dernierjour;
		Heuredebut = heuredebut;
		Heurefin = heurefin;
		this.employee=employee;
		this.reponserh = reponserh;
		this.firstname = firstname;
		this.lastname = lastname;
		this.typeCongé = typeCongé;
		this.étatDemandeCongé = étatDemandeCongé;
		this.motif = motif;
		this.congeDuration = congeDuration;
		this.user=user;
	}
	
	public Congee() {
    }
    
    
    
    
    

}
