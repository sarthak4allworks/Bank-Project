package com.tcs.bean;

public class Employee {
	private String employeeId;
	private String password;
	private String role;
	
	/*
	 * Employee Default Constructor
	 */
	public Employee(){}
	public Employee(String employeeId, String password, String role) {
		super();
		this.employeeId = employeeId;
		this.password = password;
		this.role = role;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", password=" + password + ", role=" + role + "]";
	}
}
