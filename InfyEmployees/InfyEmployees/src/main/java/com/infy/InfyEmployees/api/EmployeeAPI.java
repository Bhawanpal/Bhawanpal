package com.infy.InfyEmployees.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.InfyEmployees.dto.EmployeeDTO;
import com.infy.InfyEmployees.exception.InfyEmployeesException;
import com.infy.InfyEmployees.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee-api")
public class EmployeeAPI {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	Environment environment;
	
	static Log logger = LogFactory.getLog(EmployeeAPI.class);
	
	@PostMapping(value = "/employees")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws InfyEmployeesException{
		Integer employeeID = employeeService.addEmployee(employeeDTO);
		logger.info("Added successfully");
		String successMsg = environment.getProperty("EmployeeAPI.EMPLOYEE_REGISTRATION_SUCCESS") + employeeID;
		return new ResponseEntity<>(successMsg, HttpStatus.OK);
	}
	
	@GetMapping(value = "/employees/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("employeeId") Integer employeeId) throws InfyEmployeesException{
		EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
		logger.info("Fetched successfully");
		return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
	}
	@GetMapping(value = "/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllCustomers() throws InfyEmployeesException {
		List<EmployeeDTO> customerList = employeeService.getAllEmployee();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	@DeleteMapping(value = "/employees/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) throws InfyEmployeesException {
		employeeService.deleteEmployee(employeeId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}
