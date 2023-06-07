package gestion.rh.arab.Controller;

import java.io.IOException;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.rh.arab.Service.AuthenticationService;
import gestion.rh.arab.config.JwtService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class authAuthenticationController {

   private final AuthenticationService service;
  

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

 


	
}
