package com.infy.InfyEmployees.dto;

import java.time.LocalDate;

public class EmployeeDTO {
	
	private Integer employeeId;
	private String employeeName;
	private String employeeEmail;
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
