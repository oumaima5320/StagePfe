package gestion.rh.arab.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import gestion.rh.arab.entities.Congee;
import gestion.rh.arab.entities.DemandeCongee;
import gestion.rh.arab.entities.User;

import gestion.rh.arab.repo.DemandeCongeeRepo;
import gestion.rh.arab.repo.EmployeeRepo;
import gestion.rh.arab.repo.UserRepo;
import lombok.NoArgsConstructor;

@Service


public class DemandeCongeService {
	
	

	    private final DemandeCongeeRepo demandeCongeeRepo;
	    private final UserRepo userRepository;

	    @Autowired
	    public DemandeCongeService(DemandeCongeeRepo demandeCongeeRepo, UserRepo userRepository) {
	        this.demandeCongeeRepo = demandeCongeeRepo;
	        this.userRepository = userRepository;
	    }

	    public DemandeCongee addDemandeConge(DemandeCongee demandeConge) {
	        return demandeCongeeRepo.save(demandeConge);
	    }

	    public List<DemandeCongee> getAllDemandeConges() {
	        return demandeCongeeRepo.findAll();
	    }

	    public Optional<DemandeCongee> getDemandeCongeById(Long demandeId) {
	        return demandeCongeeRepo.findById(demandeId);
	    }

	    public DemandeCongee updateDemandeConge(DemandeCongee updatedDemandeConge) {
	        return demandeCongeeRepo.save(updatedDemandeConge);
	    }

	    public void deleteDemandeConge(Long demandeId) {
	        demandeCongeeRepo.deleteById(demandeId);
	    }
}
