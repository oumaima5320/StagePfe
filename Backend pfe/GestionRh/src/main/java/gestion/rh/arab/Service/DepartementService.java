package gestion.rh.arab.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.rh.arab.entities.Departement;
import gestion.rh.arab.repo.DepartementRepo;

@Service
public class DepartementService {
	
	

	private final DepartementRepo departementRepository;

	@Autowired
	public DepartementService(DepartementRepo departmentRepository) {
		this.departementRepository = departmentRepository;
	}

	public List<Departement> getAllDepartments() {
		return departementRepository.findAll();
	}

	public Optional<Departement> getDepartmentById(Integer id) {
		return departementRepository.findById(id);
	}

	public Departement saveDepartment(Departement departement) {
		return departementRepository.save(departement);
	}

	public void deleteDepartment(Integer id) {
		departementRepository.deleteById(id);
	}

}
