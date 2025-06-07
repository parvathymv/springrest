package com.containerize.restapidocker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.containerize.restapidocker.entity.Product;
import com.containerize.restapidocker.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	public Product getProduct(long productid) {
		return productRepository.findById(productid).get();

	}

	public Product updateProduct(Product product) {

		return productRepository.save(product);
	}

}
//docker-compose up --build

//docker exec -it  mysql_db bash mysql -u root -p
