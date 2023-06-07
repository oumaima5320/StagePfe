package gestion.rh.arab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.rh.arab.entities.DemandeCongee;

@Repository
public interface DemandeCongeeRepo extends JpaRepository<DemandeCongee,Long >{
	 
	}

