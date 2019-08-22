package org.del.service;

import org.del.dao.ICustomerDao;
import org.del.entities.Customer;
import org.del.exceptions.CustomerNotFoundException;
import org.del.exceptions.IncorrectIdException;
import org.del.exceptions.IncorrectNameException;
import org.del.exceptions.InvalidCustomerArgumentException;

import java.util.List;

/**
 * Does validatons + transaction management(cusrrent not provided)
 *
 * @author Vineet Semwal
 */
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao dao;

    public ICustomerDao getDao() {
        return dao;
    }

    public CustomerServiceImpl(ICustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public String generateId() {
        String generatedId = getDao().generateId();
        return generatedId;
    }

    @Override
    public void add(Customer customer) {
        //
        //first check customer is not null before doing further operation
        //
        notNull(customer);
        getDao().add(customer);
    }

  

    @Override
    public void update(Customer customer) {
        //
        //first checking customer is not null before doing further operation
        //
        notNull(customer);
        getDao().update(customer);
    }

    @Override
    public Customer findCustomerById(String id) throws CustomerNotFoundException {
        if (id == null || id.isEmpty()) {
            throw new IncorrectIdException("id can't be null or empty");
        }
        Customer customer = getDao().findCustomerById(id);
        return customer;
    }

    @Override
    public List<Customer> allCustomers() {
        List<Customer> customers = getDao().allCustomers();
        return customers;
    }

    /**
     * this method throws InvalidCustomerArgumentException when customer is null
     *
     * @param customer
     */
    public void notNull(Customer customer) {
        if (customer == null) {
            throw new InvalidCustomerArgumentException("customer can't be null");
        }
    }

    @Override
    public void validateCustomer(Customer customer) {
        String name = customer.getName();
        if (name == null || name.isEmpty()) {
            throw new IncorrectNameException("name can't be null or empty");
        }
    }


}













