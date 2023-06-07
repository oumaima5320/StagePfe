package gestion.rh.arab.Controller;

import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.rh.arab.entities.Attestation;
import gestion.rh.arab.repo.IAttestation;





@CrossOrigin("*")

@RestController
@RequestMapping("/attestation")
public class AttestationRest {
	@Autowired IAttestation iat;
	@GetMapping("/getall")
	public List <Attestation> getall(){
		
		return (List <Attestation>) iat.findAll(); 
	}
	@PostMapping("/save")
	public void save (@RequestBody Attestation t) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		t.setEtat("en_cours");
		t.setDatetime(timeStamp);
		
		iat.save(t);
		
	}
	@GetMapping("/getbyid/{id}")
	public Optional<Attestation> getAttestationbyid(@PathVariable("id") int id ){
		return iat.findById(id);
	}
	@PutMapping("/valider/{id}")
	 
	  public ResponseEntity<Attestation> validerAttestation(@PathVariable("id") int id, @RequestBody Attestation Clt) {
	    System.out.println("Update type ID = " + id + "...");
	     Optional<Attestation> CltData = iat.findById(id);
	    if (CltData.isPresent()) {
	    	Attestation cltt = CltData.get();
	     cltt.setTypeat(Clt.getTypeat());
	     cltt.setEtat("valider");
	     
	    
	     
	      
	     return new ResponseEntity<>(iat.save(cltt), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	   
	    	
	    	
	    	
	    	
	    }
	 @GetMapping("/getallattestationbyuser/{id}")
	    public List <Attestation> getallAttestationbyUser(@PathVariable ("id") int id){
			return ( List <Attestation>) iat.getallAttestationbyUser(id);}
	 @GetMapping("/getallAttestationbysuph/{sig}")
	 public List <Attestation> getallAttestationbysuph(@PathVariable ("sig") String sig){
		 
		 return (List <Attestation>)iat.getallAttestationbysuph(sig);
	 }
	    }
	

	
		
		
		


