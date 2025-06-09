package com.containerize.restapidocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.containerize.restapidocker.dto.ProductDTO;
import com.containerize.restapidocker.entity.Product;
import com.containerize.restapidocker.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable Long id, @RequestBody ProductDTO patchDTO) {
        return ResponseEntity.ok(productService.patchProduct(id, patchDTO));
    }
    
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }
    
    @GetMapping("/getByPrice/{price}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable double price) {
        return ResponseEntity.ok(productService.getProductByPrice(price));
    }
    
    @GetMapping("/{minprice}/{maxprice}")
    public ResponseEntity<List<Product>> getProductByPriceRange(@PathVariable double minprice,@PathVariable double maxprice) {
        return ResponseEntity.ok(productService.getProductByPriceRange(minprice,maxprice));
    }
    
    @GetMapping("findByName/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.findProductByName(name));
    }
    
    @GetMapping("/findAllProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
    
    @PutMapping("/updatePrice/{price}/{name}")
    public String updatePriceByName(@PathVariable double price ,@PathVariable String name)
    {
    	String result="Updation failed";
    	int res=productService.updatePriceByName(price,name);
    	if(res>0)
    		result= "Product price updated";
    	return result;
    }
    
    
}
