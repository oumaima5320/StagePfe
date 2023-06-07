package gestion.rh.arab.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.rh.arab.entities.Employee;
import gestion.rh.arab.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepository;
	
	


	@Autowired
	public EmployeeService(EmployeeRepo employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

}
