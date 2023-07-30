package com.infy.InfyEmployees.service;

import java.util.List;

import com.infy.InfyEmployees.dto.EmployeeDTO;
import com.infy.InfyEmployees.exception.InfyEmployeesException;

public interface EmployeeService {
	
	public EmployeeDTO getEmployee(Integer employeeId) throws InfyEmployeesException;
	
	public Integer addEmployee(EmployeeDTO employeeDTO) throws InfyEmployeesException;
	
	public List<EmployeeDTO> getAllEmployee() throws  InfyEmployeesException;
	
	public void deleteEmployee(Integer employeeId) throws InfyEmployeesException;
	
    public void updateEmployee(Integer employeeId,EmployeeDTO employeeDTO)throws InfyEmployeesException;
	
	
}
