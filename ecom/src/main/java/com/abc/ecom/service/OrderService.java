package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Order;

public interface OrderService {

	public Order saveOrder(Order order);
	
	public Order getOrderById(int orderId);
	
	public List<Order> getAllOrder();
//	get all orders
}
