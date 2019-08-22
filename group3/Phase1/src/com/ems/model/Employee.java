package com.ems.model;

import java.time.LocalDate;

public class Employee {

	private String empId;
	private String empName;
	private LocalDate DOB;
	private double basicSalary;
	
	public Employee(String empId,String empName,LocalDate DOB,double basicSalary){
		this.empId=empId;
		this.empName=empName;
		this.DOB=DOB;
		this.basicSalary=basicSalary;
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
	return "Employee [empId = "+empId+" empName = "+empName+" DOB = "+DOB+" basicSalary = "+basicSalary+"]";
}
@Override
public int hashCode() {
    if (empId == null) {
        return 0;
    }
    return empId.hashCode();
}

@Override
public boolean equals(Object obj) {
    if (obj == this) {
        return true;
    }
    if (obj == null || !(obj instanceof Employee)) {
        return false;
    }
    Employee emp = (Employee) obj;
    return emp.empId == this.empId;
}

}
