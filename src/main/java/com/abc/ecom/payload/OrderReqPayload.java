package com.abc.ecom.payload;

import java.util.List;

public class OrderReqPayload {

	private int customerId;
	private List<OrderProducts> products;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<OrderProducts> getProducts() {
		return products;
	}
	public void setProducts(List<OrderProducts> products) {
		this.products = products;
	}
	
	
	
}
