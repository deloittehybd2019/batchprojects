package com.ems.model;

import java.time.LocalDate;

public class Employee {
    private String empId;
    private String empName;
    private double basicSalary;
    private LocalDate DOB;


    public void setDate(LocalDate dob) {
        this.DOB = dob;
    }

    public void setEmpId(String empid) {
        this.empId = empid;
    }

    public void setEmpName(String empname) {
        this.empName = empname;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public Employee(String empid, String empname, double basicSalary, LocalDate dob) {
        this.empId = empid;
        this.empName = empname;
        this.basicSalary = basicSalary;
        this.DOB = dob;
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
