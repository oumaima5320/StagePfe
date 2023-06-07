package gestion.rh.arab.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="demande_congee")
public class DemandeCongee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long demandeid;
	
	 @Column(name = "date_debut")
	    private LocalDate dateDebut;

	    @Column(name = "date_fin")
	    private LocalDate dateFin;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    @Transient
	    private long congeeDuration;
	    @Column(name = "ReponseRh")
	    private String 	ReponsRh;
	    
	    
	    
	   


		


		public String getReponsRh() {
			return ReponsRh;
		}


		public void setReponsRh(String reponsRh) {
			ReponsRh = reponsRh;
		}


		public String getReponseManager() {
			return ReponseManager;
		}


		public void setReponseManager(String reponseManager) {
			ReponseManager = reponseManager;
		}


		@Column(name = "ReponseManager")
	    private String ReponseManager ;

	    // Getters and setters

	    public long getCongeeDuration() {
	        return ChronoUnit.DAYS.between(dateDebut, dateFin);
	    }

		
		public LocalDate getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(LocalDate dateDebut) {
			this.dateDebut = dateDebut;
		}

		public LocalDate getDateFin() {
			return dateFin;
		}

		public void setDateFin(LocalDate dateFin) {
			this.dateFin = dateFin;
		}

		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public void setCongeeDuration(long congeeDuration) {
			this.congeeDuration = congeeDuration;
		}


		public Long getDemandeid() {
			return demandeid;
		}


		public void setDemandeid(Long demandeid) {
			this.demandeid = demandeid;
		}


		

		public TypeDemandeCongee getTypedemandeconge() {
			return typedemandeconge;
		}


		public void setTypedemandeconge(TypeDemandeCongee typedemandeconge) {
			this.typedemandeconge = typedemandeconge;
		}


		public DemandeCongee(Long demandeid, LocalDate dateDebut, LocalDate dateFin, User user, long congeeDuration,
				String reponsRh, String reponseManager, TypeDemandeCongee typedemandeconge) {
			super();
			this.demandeid = demandeid;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
			this.user = user;
			this.congeeDuration = congeeDuration;
			ReponsRh = reponsRh;
			ReponseManager = reponseManager;
			this.typedemandeconge = typedemandeconge;
		}


		@Enumerated(EnumType.STRING)
	    @Column(name = "type_demande_conge")
	    private TypeDemandeCongee typedemandeconge;

	

		
	    
	}


