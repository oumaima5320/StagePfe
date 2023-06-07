package gestion.rh.arab.Service;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import gestion.rh.arab.Controller.AuthenticationRequest;
import gestion.rh.arab.Controller.AuthenticationResponse;
import gestion.rh.arab.Controller.RegisterRequest;


import gestion.rh.arab.config.JwtService;
import gestion.rh.arab.entities.Role;
import gestion.rh.arab.entities.User;
import gestion.rh.arab.repo.UserRepo;
import io.jsonwebtoken.io.IOException;

import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor





public class AuthenticationService {
	
	private final UserRepo repository;
	private final  PasswordEncoder passwordEncoder;
	
	
	private final  JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;

	
	
	
	public AuthenticationResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
		var user = User.builder()
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword())) // Add a closing parenthesis here
				.role(request.getRole())

				.build();
				
				repository.save(user);
				
				//int soldeConge = calculateSoldeConge(user.getTotalLeaveEntitlement());
		
				//var savedUser = repository.save(user);
			    
			    
			   
				 var response = AuthenticationResponse.builder()
					        // Existing attributes
					        //.soldeConge(soldeConge)
					        .build();

					    return response;
	}
	
	//private int calculateSoldeConge(int totalLeaveEntitlement) {
	    // Assuming you have a constant for the initial leave balance
	  //  int initialLeaveBalance = 30;
	    
	    // Calculate the soldeConge by subtracting the totalLeaveEntitlement from the initialLeaveBalance
	    //int soldeConge = initialLeaveBalance - totalLeaveEntitlement;
	    
	    // Return the calculated soldeConge
	   // return soldeConge;
	//}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getEmail(),
	            request.getPassword()
	        )
	    );
	    var user = repository.findByEmail(request.getEmail())
	        .orElseThrow();
	    var jwtToken = jwtService.generateToken(user);
	    
	    var userRole = user.getRole().toString();
	    
	    var response = AuthenticationResponse.builder()
	           
	            .token(jwtToken)
	            .role(userRole)
	            .build();
	        
	        response.setUserId(user.getId());

	        return response;
	  }

	
	


	    
	  }
	

