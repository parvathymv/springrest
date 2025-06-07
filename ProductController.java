package com.containerize.restapidocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.containerize.restapidocker.entity.Product;
import com.containerize.restapidocker.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
   ProductService productService;
	
	//@Autowired
    //Environment environment;
	
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
       // return "data of product-SERVICE, Running on port: " +environment.getProperty("local.server.port");
    }

   // http://localhost:9080/products/addProduct
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    @GetMapping("/getByProductId/{productid}")
    
    public Product getProduct(@PathVariable long productid) {
        return productService.getProduct(productid);
    }
    
    
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
