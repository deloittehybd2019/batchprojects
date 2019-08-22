package org.del.dao;

import org.del.entities.Customer;
import org.del.exceptions.CustomerNotFoundException;

import java.util.*;

/**
 * fetches ,stores ,updates customer in storage
 *
 */
public class CustomerDaoImpl implements ICustomerDao {
    private Map<String, Customer> store = new HashMap<>();

    public Map<String, Customer> getStore() {
        return store;
    }

    private int generatedId;

    @Override
    public String generateId() {
        generatedId++;
        String idStr = "" + generatedId;
        return idStr;
    }

    @Override
    public void add(Customer customer) {
        getStore().put(customer.getId(), customer);
    }

    @Override
    public void update(Customer customer){
         getStore().put(customer.getId(),customer);
    }


  

    @Override
    public Customer findCustomerById(String id) throws CustomerNotFoundException {
        Customer customer = getStore().get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found for id=" + id);
        }
        return customer;
    }

    @Override
    public List<Customer> allCustomers() {
        Collection<Customer> values = store.values();
        List<Customer> list = new ArrayList<>(values);
        return list;
    }
}
















