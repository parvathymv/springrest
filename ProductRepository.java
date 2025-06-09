package com.containerize.restapidocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.containerize.restapidocker.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// Derived queries
	Product findByName(String name);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	List<Product> findByPriceGreaterThan(double price);

	// Custom query
	@Query("SELECT p FROM Product p WHERE p.name = :name")
	Product findByProductName(@Param("name") String name);

	@Query(value = "SELECT * FROM product_details", nativeQuery = true)
	List<Product> findAllProducts();

//DML queries
	@Modifying
	@Query("UPDATE Product p SET p.price = :price WHERE p.name = :name")
	int updatePriceByName(@Param("price") double price, @Param("name") String name);

	@Modifying
	@Query("DELETE FROM Product p WHERE p.name = :name")
	void deleteByName(@Param("name") String name);

}
