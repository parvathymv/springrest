package com.containerize.restapidocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.containerize.restapidocker.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}
