package com.abc.ecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Order;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.CustomerRepository;
import com.abc.ecom.repository.OrderRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository=null;
	
	@Autowired
	OrderRepository orderRepository=null;
	
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		customerList = customerRepository.findAll();
		return customerList;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}

	@Override
	public Customer getCustomerById(int customerId) throws ResourceNotFoundException {
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer with id:"+customerId+" not Found");
		}
		Customer customer = optionalCustomer.get();
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.delete(getCustomerById(customerId));
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = customerRepository.save(getCustomerById(customer.getCustomerId()));
		return updatedCustomer;
	}

	@Override
	public List<Order> getOrderByCustomerId(int customerId) {
		
		List<Order> customerOrder = orderRepository.getOrdersForCustomer(customerId);
		return customerOrder;
	}

	

	
}
