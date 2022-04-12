package com.abc.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.ecom.entity.Order;
import com.abc.ecom.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

	
}
