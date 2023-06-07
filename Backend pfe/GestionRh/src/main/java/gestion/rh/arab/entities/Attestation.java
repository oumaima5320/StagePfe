package gestion.rh.arab.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attestation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "type_at")
	private TypeAttestation typeat;
	private String etat;
	@ManyToOne @JoinColumn(name="type_userid")
	private User us;
	private String Datetime;
	private String Approbateur_demande;
	public Attestation() {
		super();
	}

	

	public String getDatetime() {
		return Datetime;
	}



	public void setDatetime(String datetime) {
		Datetime = datetime;
	}



	


	public Attestation(Integer id, TypeAttestation typeat, String etat, User us, String datetime,
			String approbateur_demande) {
		super();
		this.id = id;
		this.typeat = typeat;
		this.etat = etat;
		this.us = us;
		Datetime = datetime;
		Approbateur_demande = approbateur_demande;
	}
	



	public String getApprobateur_demande() {
		return Approbateur_demande;
	}



	public void setApprobateur_demande(String approbateur_demande) {
		Approbateur_demande = approbateur_demande;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeAttestation getTypeat() {
		return typeat;
	}

	public void setTypeat(TypeAttestation typeat) {
		this.typeat = typeat;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public User getUs() {
		return us;
	}

	public void setUs(User us) {
		this.us = us;
	}
	
	
	

}