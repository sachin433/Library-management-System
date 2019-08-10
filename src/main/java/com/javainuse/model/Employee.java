package com.javainuse.model;

public class Employee {

	private String EmpId;
	private String Password;
	private String EmpEmail;
	private String EmpName;
	

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String EmpName) {
		this.EmpName = EmpName;
	}

	public String getEmpEmail() {
		return EmpEmail;
	}

	public void setEmpEmail(String EmpEmail) {
		this.EmpEmail = EmpEmail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		this.EmpId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + EmpId + ", password=" + Password +"]";
	}

}