package gestion.rh.arab.config;

import java.util.Arrays;

import org.apache.catalina.Manager;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor


public class SecurityConfiguration {
	
	//private final JwtAuthentificationFilter jwtAuthFilter = new JwtAuthentificationFilter();
	//private final AuthenticationProvider authenticationProvider = new MyAuthenticationProvider();

	private final JwtAuthentificationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
	http
	.csrf()
	.disable()
	 .cors().and()
	.authorizeHttpRequests()
	.antMatchers("/api/v1/auth/**")
	.permitAll()
	
	.anyRequest()
	.authenticated()
	.and()
	.sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	.and()
	.authenticationProvider(authenticationProvider)
	.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	
		
		
		
		
		return http.build();
		
		
	}
	 @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	
	  @Bean
	    public CorsFilter corsFilter() {
	        CorsConfigurationSource source = corsConfigurationSource();
	        return new CorsFilter(source);
	    }

}
