package org.del.entities;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
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


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj==null|| !(obj.getClass().equals(Employee.class))){
            return false;
        }
        Employee e=(Employee)obj;
        return e.id==this.id;
    }
}
