package gestion.rh.arab.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.rh.arab.entities.Autorisation;





public interface AutorisationRepo extends JpaRepository<Autorisation, Integer> {
	@Query("select s from Autorisation s where s.user.id=:x")
	public List <Autorisation> getallAutorisationbyUser(@Param("x")int id);


}


