package com.containerize.restapidocker.service;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.containerize.restapidocker.dto.ProductDTO;
import com.containerize.restapidocker.entity.Product;
import com.containerize.restapidocker.exception.ResourceNotFoundException;
import com.containerize.restapidocker.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
    public Product patchProduct(Long id, ProductDTO patchDTO) {
        Product product = getProductById(id);

        if (patchDTO.getName() != null) {
            product.setName(patchDTO.getName());
        }
        if (patchDTO.getPrice() != null) {
            product.setPrice(patchDTO.getPrice());
        }

        return productRepository.save(product);
    }

	public Product getProductByName(String name) {
	
		return productRepository.findByName(name);
	}

	public List<Product> getProductByPrice(double price) {
		return productRepository.findByPriceGreaterThan(price);
	}

	public List<Product> getProductByPriceRange(double minprice, double maxprice) {
		
		return productRepository.findByPriceBetween(minprice, maxprice);
	}

	public Product findProductByName(String name) {
		
		return productRepository.findByProductName(name);
	}

	public List<Product> findAllProducts() {
		
		return productRepository.findAllProducts();
	}

	@Transactional
	public int updatePriceByName(double price, String name) {

		return productRepository.updatePriceByName(price, name);
	}
	
}
