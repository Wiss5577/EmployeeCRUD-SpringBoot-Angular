package org.sid.springboot.repositories;

import java.util.List;

import org.sid.springboot.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;


@Repository //contient plusieurs méthodes CRUD
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//on cree les méthodes qui n'existent pas 
@Transactional
@Modifying
@Query(value = "select * from employees where last_name = ?1", nativeQuery = true)
public List<Employee> GetEmployeeByName(String last_name);


@Transactional
@Modifying
@Query(value = "select * from employees where first_name = ?1", nativeQuery = true)
public List<Employee> GetEmployeeByFName(String first_name);

}

