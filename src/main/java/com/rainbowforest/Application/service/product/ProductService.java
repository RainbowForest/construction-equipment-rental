package com.rainbowforest.Application.service.product;

import java.util.List;
import com.rainbowforest.Application.model.catalog.Product;

public interface ProductService {
	
	/**
	 * Returns the current list of all products
	 * 
	 * @return list of objects of type Product
	 */
	List<Product> findAllProducts();
	
	/**
	 * Finds a single product for the given product id
	 * 
	 * @param id, product id
	 * @return an object of type Product for the given product id
	 */
	Product findOneProduct(Integer id);
	
	/**
	 * Finds a single product for the given product name
	 * 
	 * @param productName
	 * @return an object of type Product for the given product name
	 */
	Product findOneProductByName(String productName);
	
	/**
	 * Saves a single object of type Product
	 * 
	 * @param product, an object of type Product
	 */
	public void saveProduct(Product product);
	
	/**
	 * Updates the Product based on product ID
	 * 
	 * @param newProductCode
	 * @param newProductName
	 * @param newProductCategory
	 * @param newAvailability
	 * @param newProductPrice
	 * @param id, product ID
	 */
	public void updateItem(
			String newProductCode,
			String newProductName,
			String newProductCategory,
			int newAvailability,
			double newProductPrice,
			int id);
}
