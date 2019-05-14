package com.rainbowforest.Application.service.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.catalog.Product;
import com.rainbowforest.Application.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product findOneProduct(Integer id) {
		Product product = productRepository.findOneProductById(id);
		return product;
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product findOneProductByName(String productName) {
		Product product = productRepository.findOneByProductName(productName);
		return product;
	}

	@Override
	public void updateItem(
			String newProductCode, 
			String newProductName, 
			String newProductCategory, 
			int newAvailability,
			double newProductPrice, 
			int id) {
		
		productRepository.updateItem(
				newProductCode, 
				newProductName, 
				newProductCategory, 
				newAvailability, 
				newProductPrice, 
				id);		
	}
}
