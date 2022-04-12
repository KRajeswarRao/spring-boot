package com.abc.ecom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Order;
import com.abc.ecom.service.CustomerService;
import com.abc.ecom.service.OrderService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();

		return customers;
	}

	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) { // RequestBody converts json to object
		Customer newCustomer = customerService.saveCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;

	}

	@GetMapping("/get/{demoid}") // {id} is replaced with customerId
	public ResponseEntity<Object> fetchCustomerById(@PathVariable("demoid") int customerId) {

		ResponseEntity<Object> responseEntity = null;

		Customer customer = customerService.getCustomerById(customerId);
		responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);

		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable("id") int customerId) {

		ResponseEntity<Object> responseEntity = null;

		customerService.deleteCustomer(customerId);
		responseEntity = new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);

		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
		ResponseEntity<Object> responseEntity = null;

		Customer updatedCustomer = customerService.updateCustomer(customer);
		responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/orderlist/{customerId}")
	public List<Order> fetchOrdersByCustomerId(@PathVariable("customerId") int customerId){
		List<Order> orderList = customerService.getOrderByCustomerId(customerId);
		return orderList;
	}

}
