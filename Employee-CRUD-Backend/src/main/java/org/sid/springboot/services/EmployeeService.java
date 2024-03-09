package org.sid.springboot.services;
import org.sid.springboot.models.Employee;
import org.sid.springboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository EmpRepository;
	
	//Services
	
	public List<Employee> GetAllEmp(){
		return EmpRepository.findAll();
	}
	
	public Optional<Employee> GetOneEmp(long id) {
		
		return EmpRepository.findById(id);
	}
	
	public void AddEmp (Employee employee) {
		
		EmpRepository.save(employee);
	}
	
    public void UpdateEmp (Employee employee) {
		
		EmpRepository.save(employee);
	}
    
    
    public void DeleteEmp (long id) {
    	EmpRepository.deleteById(id);
    }
    
    
    public List<Employee> GetEmpByName (String last_name) {
    return 	EmpRepository.GetEmployeeByName(last_name);
    }
    
    
    public List<Employee> GetEmpByFName (String first_name) {
        return 	EmpRepository.GetEmployeeByFName(first_name);
        }
}
