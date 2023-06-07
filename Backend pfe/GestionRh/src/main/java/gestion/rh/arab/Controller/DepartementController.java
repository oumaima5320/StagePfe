package gestion.rh.arab.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import gestion.rh.arab.Service.DepartementService;
import gestion.rh.arab.entities.Departement;



@RestController
@RequestMapping("/departements")
@CrossOrigin("*")

public class DepartementController {
	private final DepartementService departmentService;

	@Autowired
	public DepartementController(DepartementService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping
	public ResponseEntity<List<Departement>> getAllDepartments() {
		List<Departement> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departement> getDepartmentById(@PathVariable Integer id) {
		Optional<Departement> department = departmentService.getDepartmentById(id);
		return department.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Departement> createDepartment(@RequestBody Departement department) {
		Departement createdDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Departement> updateDepartment(@PathVariable Integer id, @RequestBody Departement department) {
		Optional<Departement> existingDepartment = departmentService.getDepartmentById(id);
		if (existingDepartment.isPresent()) {
			department.setId(id);
			Departement updatedDepartment = departmentService.saveDepartment(department);
			return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
		Optional<Departement> existingDepartment = departmentService.getDepartmentById(id);
		if (existingDepartment.isPresent()) {
			departmentService.deleteDepartment(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
