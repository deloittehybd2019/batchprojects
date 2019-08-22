package org.del.frontend;

import org.del.dao.EmployeeDaoImpl;
import org.del.dao.EmployeeJdbcDaoImpl;
import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;
import org.del.service.IEmployeeService;
import org.del.service.EmployeeServiceImpl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Ui {
    IEmployeeService service = new EmployeeServiceImpl(new EmployeeJdbcDaoImpl());

    public static void main(String[] args) throws EmployeeNotFoundException {
        Ui ui = new Ui();
        ui.runUi();
    }

    public void runUi() throws EmployeeNotFoundException {
        Employee employee1 = new Employee("kartik22nailwal@gmail.com", "pwd","Kartik", "India");
        //
        //adding customer
        //
        service.add(employee1);

       String desiredEmailId = employee1.getEmailId();
       Object obj = service.showEmployee(desiredEmailId);
       Employee employee2 = (Employee) obj;
       System.out.println(employee2);
    }

/*
    public void addCustomer(Customer customer) {
        try {
            System.out.println("***add operation started***");
            service.add(customer);
            System.out.println("customer added successfully");
        } catch (Throwable e) {
            System.out.println("Customer could not be added");

        }
    }


    public void displayCustomerById(String id) {
        try {
            System.out.println("***displaying customer by id operation started**");
            Customer fetched = service.findCustomerById(id);
            displayCustomer(fetched);
        } catch (CustomerNotFoundException e) {
            System.out.println("customer not found for id=" + id);
        } catch (Throwable e) {
            System.out.println("something went wrong, couldn't fetch for id=" + id);
        }
    }

    public void displayCustomer(Customer customer) {
        LocalDate birthDate=customer.getBirthDate();
        System.out.println("customer=" + customer.getId() + " name=" + customer.getName()+
                " birthdate="+birthDate.getDayOfMonth()+"-"+birthDate.getMonthValue()+"-"+birthDate.getYear());
    }

    public void displayAllCustomers() {
        System.out.println("***displaying all customers operation started**");
        List<Customer> customers = service.allCustomers();
        for (Customer customer : customers) {
            displayCustomer(customer);
        }
    }
    */
}
