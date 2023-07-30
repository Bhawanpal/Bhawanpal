package com.infy.InfyEmployees;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.InfyEmployees.dto.EmployeeDTO;
import com.infy.InfyEmployees.entity.Employee;
import com.infy.InfyEmployees.exception.InfyEmployeesException;
import com.infy.InfyEmployees.repository.EmployeeRepository;
import com.infy.InfyEmployees.service.EmployeeService;
import com.infy.InfyEmployees.service.EmployeeServiceImpl;

@SpringBootTest
class InfyEmployeesApplicationTests {

	@Mock
	EmployeeRepository employeerepository;
	
	@InjectMocks
	EmployeeService employeeService=new EmployeeServiceImpl();
	
    @Test
    public void getEmployeeInvalidEmployeeID() {
    	Employee e= new Employee();
    	e.setEmployeeId(999999);
    	Mockito.when(employeerepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
    	Exception exception=Assertions.assertThrows(InfyEmployeesException.class,()->employeeService.getEmployee(e.getEmployeeId()));
    	Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND",exception.getMessage());
    }
    @Test
    public void deleteEmployeeEmployeeNotFound() {
    	Integer employeeId=101080;
    	Mockito.when(employeerepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
    	Exception exception=Assertions.assertThrows(InfyEmployeesException.class,()->employeeService.deleteEmployee(employeeId));
    	Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND_TO_DELETE",exception.getMessage());
    }
    @Test
	public void addEmployeeValid() throws InfyEmployeesException{
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(1);
		employeeDTO.setEmployeeName("John");
		employeeDTO.setEmployeeEmail("john@infy.com");		
		//employeeDTO.setEmployeeDOB();
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setEmployeeDOB(employeeDTO.getEmployeeDOB());
		employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
		
		
		Optional<Employee> optional = Optional.of(employee);
		
		Mockito.when(employeerepository.findById(Mockito.anyInt()))
		.thenReturn(optional);
		
		Mockito.when(employeerepository.save(Mockito.any())).thenReturn(employee);
		
//		Assertions.assertDoesNotThrow(() -> employeeService.addEmployee(employeeDTO));
		
Exception exception= Assertions.assertThrows(InfyEmployeesException.class,() -> employeeService.addEmployee(employeeDTO));
		
		Assertions.assertEquals("Service.EMPLOYEE_ALREADY_PRESENT",exception.getMessage());
	}
}
