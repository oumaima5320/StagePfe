package gestion.rh.arab.config;

import java.security.Key;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Service
public class JwtService {
	
	private static final String SECRET_Key = "66546A576E5A7234753778214125442A472D4B6150645367566B587032733576"
			;

  

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public String generateToken(UserDetails userDetails) {
	  return generateToken(new HashMap<>(), userDetails);
  }
 
  public String generateToken(
		  Map<String, Object> extracClaims,
		  UserDetails userDetails
		  )
  {
	  return Jwts.builder().setClaims(extracClaims).setSubject(userDetails.getUsername())
			  .setIssuedAt(new Date(System.currentTimeMillis()))
			  .setExpiration(new Date(System.currentTimeMillis() + 1000 *60 *24))
			  .signWith(getSignInKey(), SignatureAlgorithm.HS256)
			  .compact();
  }
   
   public boolean isTokenValid(String token , UserDetails userDetails) {
	   final String username = extractUsername(token);
	   return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
   }

  private boolean isTokenExpired(String token) {
	// TODO Auto-generated method stub
	return extractExpiration(token).before(new Date());
}

private Date extractExpiration(String token) {
	// TODO Auto-generated method stub
	return extractClaim(token,Claims::getExpiration);
}

private String buildToken(
          Map<String, Object> extraClaims,
          UserDetails userDetails,
          long expiration
  ) {
    return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact();
  }

  
 
  

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_Key);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
