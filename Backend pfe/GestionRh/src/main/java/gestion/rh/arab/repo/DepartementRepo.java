package gestion.rh.arab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.rh.arab.entities.Departement;


@Repository
public interface DepartementRepo extends JpaRepository<Departement, Integer> {

}
