package com.ems.model;

import java.time.LocalDate;

public class Employee {

	private String empId;
	private String empName;
	private LocalDate DOB;
	private double basicSalary;
	
	public Employee(String empId, String empName, LocalDate dOB, double basicSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		DOB = dOB;
		this.basicSalary = basicSalary;
	}
	@Override
	public int hashCode() {
		if(empId==null) {
			return 0;
		}
		return empId.hashCode();
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
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (Double.doubleToLongBits(basicSalary) != Double.doubleToLongBits(other.basicSalary))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", DOB=" + DOB + ", basicSalary=" + basicSalary
				+ "]";
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
	
}