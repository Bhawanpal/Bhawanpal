package com.infy.InfyEmployees.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.InfyEmployees.dto.EmployeeDTO;
import com.infy.InfyEmployees.entity.Employee;
import com.infy.InfyEmployees.exception.InfyEmployeesException;
import com.infy.InfyEmployees.repository.EmployeeRepository;


@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	
	@Override
	public EmployeeDTO getEmployee(Integer employeeId) throws InfyEmployeesException{

		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee = optionalEmployee.orElseThrow( ()-> new InfyEmployeesException("Service.EMPLOYEE_NOT_FOUND"));
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employeeId);
		employeeDTO.setEmployeeName(employee.getEmployeeName());
		employeeDTO.setEmployeeDOB(employee.getEmployeeDOB());
		employeeDTO.setEmployeeEmail(employee.getEmployeeEmail());
		return employeeDTO;
	}
	
	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) throws InfyEmployeesException {
		if (!employeeRepository.findById(employeeDTO.getEmployeeId()).isEmpty()) {
			throw new InfyEmployeesException("Service.EMPLOYEE_ALREADY_PRESENT");
		} else {
			Employee employee = new Employee();
			employee.setEmployeeId(employeeDTO.getEmployeeId());
			employee.setEmployeeName(employeeDTO.getEmployeeName());
			employee.setEmployeeDOB(employeeDTO.getEmployeeDOB());
			employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
			
			Employee returnedEmployee = employeeRepository.save(employee);
			return returnedEmployee.getEmployeeId();
		}
		
	}
	
	
	
	
	
	@Override
	public List<EmployeeDTO> getAllEmployee() throws  InfyEmployeesException{
		Iterable<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employees2 = new ArrayList<>();
		employees.forEach(employee -> {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeId(employee.getEmployeeId());
			emp.setEmployeeDOB(employee.getEmployeeDOB());
			emp.setEmployeeEmail(employee.getEmployeeEmail());
			emp.setEmployeeName(employee.getEmployeeName());
			employees2.add(emp);
		});
		if (employees2.isEmpty())
			throw new InfyEmployeesException ("Service.EMPLOYEE_NOT_FOUND");
		return employees2;
		}
	
	@Override
	public void deleteEmployee(Integer employeeId) throws InfyEmployeesException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		employee.orElseThrow(() -> new InfyEmployeesException("Service.EMPLOYEE_NOT_FOUND_TO_DELETE"));
		employeeRepository.deleteById(employeeId);
	}
      
	@Override
	public void updateEmployee( Integer employeeId,EmployeeDTO employeeDTO) throws InfyEmployeesException {
	Optional<Employee> employee = employeeRepository.findById(employeeId);
	Employee e = employee.orElseThrow(() -> new InfyEmployeesException("Service.EMPLOYEE_NOT_FOUND"));
	
	e.setEmployeeEmail(employeeDTO.getEmployeeEmail());
	e.setEmployeeDOB(employeeDTO.getEmployeeDOB());
	e.setEmployeeName(employeeDTO.getEmployeeName());
	}
	}

