package org.del.entities;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

    public Employee( String name,String password,String email, String country) {
        this.name = name;
        this.password=password;
        this.email=email;
        this.country=country;
    }


    public Employee() {

    }

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    private String email;
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email=email;
    }
    
    @NotNull
    private String country;
    
    public String getCountry() {
    	return country;
    }
    
    public void setCountry(String country) {
    	this.country=country;
    }
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj.getClass().equals(Employee.class))) {
            return false;
        }
        Employee e = (Employee) obj;
        return e.id == this.id;
    }
}
