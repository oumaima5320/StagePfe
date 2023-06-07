package gestion.rh.arab.entities;




import java.util.ArrayList;
import java.util.Collection;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@AllArgsConstructor
@Entity

public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)

	private Long id;
	private String firstname;
	
	
	


	private String lastname;
	private String password;
	private String email;
	private Integer soldeConge;
	 private Integer congeDuration; 
	private Integer totalLeaveEntitlement;
	
	public Integer getSoldeConge() {
        return soldeConge;
    }

    public void setSoldeConge(Integer soldeConge) {
        this.soldeConge = soldeConge;
    }
	
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	 public User() {
	        // Default constructor with no arguments
	    }


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true ;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	
	@Enumerated(EnumType.STRING)
    private Role role ;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toString()));
	    return authorities;
	}

	public Integer getTotalLeaveEntitlement() {
	    return totalLeaveEntitlement;
	}
	
	public void setTotalLeaveEntitlement(Integer totalLeaveEntitlement) {
	    this.totalLeaveEntitlement = totalLeaveEntitlement;
	}


	

	public void setSoldeCongee(Integer soldeConge) {
	    this.soldeConge = soldeConge;
	}


	public void setCongeDuration(int totalLeavesTaken) {
		// TODO Auto-generated method stub
		
	}



	public Integer getCongeDuration() {
	    // Return the congé duration value
	    return congeDuration;
	}

	public void setCongeDuration(Integer congeDuration) {
	    this.congeDuration = congeDuration;
	}


	}
	
	
        
	

	
	
	
	
	
	


	
	
	
	
	

