package com.infy.InfyEmployees.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.InfyEmployees.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
