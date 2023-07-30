package com.infy.InfyEmployees.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.InfyEmployees.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
