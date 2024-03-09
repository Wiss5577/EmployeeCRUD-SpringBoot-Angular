package org.sid.springboot.controllers;
import java.util.List;
import java.util.Optional;
import org.sid.springboot.models.Employee;
import org.sid.springboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/")

//CRUD 
public class EmployeeController {
	
@Autowired
private EmployeeService employeeservice;


//Ajouter un employé (C)

@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/addemployee")
public void CreateNewEmployee(@RequestBody Employee employee) throws Exception{
	employeeservice.AddEmp(employee);
}


//Liste des employés (R)

@GetMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public List<Employee> ReadEmployees(){
	return employeeservice.GetAllEmp();
}

//Modifier les info d'un employé (U)

@CrossOrigin(origins = "http://localhost:4200")
@PutMapping("/updateemployee")
public void UpdateEmployee(@RequestBody Employee employee) throws Exception{
	employeeservice.UpdateEmp(employee);
}

//Supprimer un employé

@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/deleteemployee/{id}")
public void DeleteEmployee(@PathVariable long id) throws Exception{
	employeeservice.DeleteEmp(id);
}


//Get One Employee by his ID

@GetMapping("/employee/{id}")
@CrossOrigin(origins = "http://localhost:4200")
public Optional<Employee> GetOneEmployee(@PathVariable long id){//PathVariable indique que il faut l'envoyer par url api
	Optional<Employee> emp =employeeservice.GetOneEmp(id);
	return emp;
}

//Get Employee by his lastname
@GetMapping("/cherchebylast/{nom}")
@CrossOrigin(origins = "http://localhost:4200")
public List<Employee> GetEmployeeByName(@PathVariable String nom){ 
	List<Employee> emp =employeeservice.GetEmpByName(nom);
	return emp;
}

//Get Employee by his firstname
@GetMapping("/cherchebyfirst/{prenom}")
@CrossOrigin(origins = "http://localhost:4200")
public List<Employee> GetEmployeeByFName(@PathVariable String prenom){
	List<Employee> emp =employeeservice.GetEmpByFName(prenom);
	return emp;
}
}
