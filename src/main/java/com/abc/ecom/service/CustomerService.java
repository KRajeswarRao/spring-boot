package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Order;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer saveCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	public void deleteCustomer(int customerId);

	public Customer updateCustomer(Customer customer);
	
	public List<Order> getOrderByCustomerId(int customerId);
	//get all orders by customer id

}
