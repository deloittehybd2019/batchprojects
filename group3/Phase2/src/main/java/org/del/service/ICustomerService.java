package org.del.service;

import org.del.entities.Customer;
import org.del.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    void add(Customer customer);

   
    void update(Customer customer);

    List<Customer> allCustomers();

    void validateCustomer(Customer customer);

    Customer findCustomerById(String id) throws CustomerNotFoundException;

    String generateId();
}
