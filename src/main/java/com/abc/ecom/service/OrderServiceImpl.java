package com.abc.ecom.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Order;
import com.abc.ecom.entity.OrderItem;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Order saveOrder(Order order) {
		
		order.setOrderDate(LocalDate.now());		
		List<OrderItem> orderItems = order.getOrderItems();
		double orderTotalItem=0;
		
		for(OrderItem o:orderItems) {
//			Optional<Product> product = productRepository.findById(p.getProductId());
			Product product = productService.getProductById(o.getProductId());			
			double unitPrice = product.getProductPrice();
			int quantity = o.getQuantity();
			orderTotalItem=orderTotalItem+(unitPrice*quantity);
			o.setOrder(order);
		}
		//if any gst or other tax calculate here and add to the total
		
		order.setOrderAmount(orderTotalItem);
		Order newOrder = orderRepository.save(order);
		return newOrder;
	}

	@Override
	public Order getOrderById(int orderId) {
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("No order found with order ID:"+orderId);
		}
		Order order = optionalOrder.get();
		
		return order;
	}

	
	
	@Override
	public List<Order> getAllOrder() {
		List<Order> orderList = orderRepository.findAll();
		return orderList;
	}
}
