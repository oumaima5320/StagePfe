package gestion.rh.arab.Controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {
	
	private String token;
	
	private Long userId;
	
	private String role;
	private Integer soldeConge;
	
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	 public void setUserId(Long id) {
	        this.userId = id;
	    }

	 public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	
	}
	
	


