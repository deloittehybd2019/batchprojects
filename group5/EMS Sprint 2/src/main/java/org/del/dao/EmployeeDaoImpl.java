package org.del.dao;

import org.del.entities.Employee;

import java.util.*;

/**
 * fetches ,stores ,updates customer in storage
 *
 */
public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee showEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}
   /* private Map<String, Customer> store = new HashMap<>();

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
    public void remove(Customer customer) {
        getStore().remove(customer.getId());
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
    */
}
















