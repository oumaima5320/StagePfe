package gestion.rh.arab.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.rh.arab.entities.User;





@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	
	//User findByUsername(String username);
	Optional<User> findByEmail(String email);

	Optional<User> findById(Integer employeeId);
	
	
}
 