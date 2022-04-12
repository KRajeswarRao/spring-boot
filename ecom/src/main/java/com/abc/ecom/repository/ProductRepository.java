package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Product;


//JpaRepository<Product,dataType of primary key> 
//@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	
	
}
