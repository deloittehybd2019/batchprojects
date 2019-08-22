package com.ems.model;

import java.time.LocalDate;

public class Employee {

	private String empId;
	private String empName;
	private LocalDate DOB;
	private double basicSalary;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", DOB=" + DOB + ", basicSalary=" + basicSalary
				+ "]";
	}

	public Employee(String empName, LocalDate dOB, double basicSalary) {
         
		
		this.empName = empName;
		DOB = dOB;
		this.basicSalary = basicSalary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Employee() {

	}

}
