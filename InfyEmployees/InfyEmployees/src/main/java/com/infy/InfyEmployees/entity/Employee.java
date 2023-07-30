package com.infy.InfyEmployees.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
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
	@Override
	public int hashCode() {
		return Objects.hash(employeeDOB, employeeEmail, employeeId, employeeName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeDOB, other.employeeDOB) && Objects.equals(employeeEmail, other.employeeEmail)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName);
	}
	
	
}
