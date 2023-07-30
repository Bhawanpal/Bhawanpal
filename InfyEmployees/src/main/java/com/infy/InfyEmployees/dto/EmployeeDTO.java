package com.infy.InfyEmployees.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDTO {
	
	private Integer employeeId;
	
	@NotNull(message="{employee.name.absent}")
	@Pattern(regexp="[A-Za-z]+( [A-Za-z)+)*",message="{employee.name.invalid}")
	private String employeeName;
	
//	@Email(message="{employee.emailid.invalid}")
//	@NotNull(message="{employee.email.absent}")
	
	@Email(message="{employee.emaild.absent}")
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",message="{employee.emailid.invalid}")
//	"\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"
	private String employeeEmail;
	
	@NotNull
	private LocalDate employeeDOB;
	
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	
	
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public LocalDate getEmployeeDOB() {
		return employeeDOB;
	}
	public void setEmployeeDOB(LocalDate employeeDOB) {
		this.employeeDOB = employeeDOB;
	}
	
	
}
