package gestion.rh.arab.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.rh.arab.Service.DemandeCongeService;
import gestion.rh.arab.entities.DemandeCongee;
import gestion.rh.arab.entities.User;

@RestController
@RequestMapping("/api/demandeconge")
@CrossOrigin("*")
public class DemandeCongeeController {
	
	

	private final DemandeCongeService demandeCongeeService;

    public DemandeCongeeController(DemandeCongeService demandeCongeeService) {
        this.demandeCongeeService = demandeCongeeService;
    }

    @PostMapping("/savedemande")
    public ResponseEntity<DemandeCongee> addDemandeConge(@RequestBody DemandeCongee demandeConge) {
        // Update user's solde congé
        User user = demandeConge.getUser();
        int totalEntitlement = user.getTotalLeaveEntitlement();
        
        // Calculate congé duration
        long congéDuration = calculateCongeDuration(demandeConge.getDateDebut(), demandeConge.getDateFin());
        
        // Calculate total leaves taken
        int totalLeavesTaken = user.getCongeDuration() != null ? user.getCongeDuration() : 0;
        totalLeavesTaken += congéDuration;

        int soldeConge = totalEntitlement - totalLeavesTaken;
        user.setCongeDuration(totalLeavesTaken);
        user.setSoldeConge(soldeConge);

        DemandeCongee savedDemandeConge = demandeCongeeService.addDemandeConge(demandeConge);
        return ResponseEntity.ok(savedDemandeConge);
    }

    private long calculateCongeDuration(LocalDate startDate, LocalDate endDate) {
        // Calculate the difference between start and end dates
        long durationDays = ChronoUnit.DAYS.between(startDate, endDate);

        // Add 1 to include the start date
        return durationDays + 1;
    }




    @GetMapping
    public ResponseEntity<List<DemandeCongee>> getAllDemandeConges() {
        List<DemandeCongee> demandeConges = demandeCongeeService.getAllDemandeConges();
        return ResponseEntity.ok(demandeConges);
    }

    @GetMapping("/{demandeid}")
    public ResponseEntity<DemandeCongee> getDemandeCongeById(@PathVariable Long demandeid) {
        Optional<DemandeCongee> demandeConge = demandeCongeeService.getDemandeCongeById(demandeid);
        if (demandeConge.isPresent()) {
            return ResponseEntity.ok(demandeConge.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{demandeid}")
    public ResponseEntity<DemandeCongee> updateDemandeConge(@PathVariable Long demandeid, @RequestBody DemandeCongee updatedDemandeConge) {
        Optional<DemandeCongee> demandeConge = demandeCongeeService.getDemandeCongeById(demandeid);
        if (demandeConge.isPresent()) {
            DemandeCongee savedDemandeConge = demandeCongeeService.updateDemandeConge(updatedDemandeConge);
            return ResponseEntity.ok(savedDemandeConge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{demandeid}")
    public ResponseEntity<Void> deleteDemandeConge(@PathVariable Long demandeid) {
        demandeCongeeService.deleteDemandeConge(demandeid);
        return ResponseEntity.noContent().build();
    }
}
