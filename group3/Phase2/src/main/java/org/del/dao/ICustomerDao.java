package org.del.dao;

import org.del.entities.Customer;
import org.del.exceptions.CustomerNotFoundException;

import java.util.List;

/**
 * Data access specification for Customer
 */
public interface ICustomerDao {

    void add(Customer customer);

   

    Customer findCustomerById(String id) throws CustomerNotFoundException;

    void update(Customer customer);
    String generateId();

    List<Customer> allCustomers();
}
