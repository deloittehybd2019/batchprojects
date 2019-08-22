package com.ems.model;
import java.time.LocalDate;
import java.util.*;

public class Employee {
	String empId;
	String empName;
	LocalDate DOB;
	double basicSalary;
	public Employee(String empName, LocalDate DOB, double basicSalary) {
		this.empName = empName;
		this.DOB = DOB;
		this.basicSalary = basicSalary;
	}
	
	public Employee(String empId, String empName, LocalDate DOB, double basicSalary) {
		this.empId = empId;
		this.empName = empName;
		this.DOB = DOB;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", DOB=" + DOB + ", basicSalary=" + basicSalary
				+ "]";
	}
	
	
	
	

}
