package gestion.rh.arab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.rh.arab.entities.Employee;


@Repository

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
