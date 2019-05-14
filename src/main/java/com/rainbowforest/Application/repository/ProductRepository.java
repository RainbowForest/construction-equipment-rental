package com.rainbowforest.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.catalog.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findOneByProductName(String productName);
	
	@Modifying
	@Query("UPDATE Product p "
			+ "SET "
			+ "p.productCode = :newProductCode, "
			+ "p.productName = :newProductName, "
			+ "p.productCategory = :newProductCategory, "
			+ "p.availability = :newAvailability, "
			+ "p.productPrice = :newProductPrice "
			+ "WHERE p.id = :id")
	public void updateItem(
			@Param("newProductCode") String newProductCode,
			@Param("newProductName") String newProductName,
			@Param("newProductCategory") String newProductCategory,
			@Param("newAvailability") int newAvailability,
			@Param("newProductPrice") double newProductPrice,
			@Param("id") int id);
		
	@Query("SELECT p FROM Product p WHERE p.id = :id")
	public Product findOneProductById(@Param("id") Integer id);	
}
