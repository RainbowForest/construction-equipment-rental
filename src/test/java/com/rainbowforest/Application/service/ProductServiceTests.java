package com.rainbowforest.Application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.rainbowforest.Application.model.catalog.Product;
import com.rainbowforest.Application.repository.ProductRepository;
import com.rainbowforest.Application.service.product.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductServiceTests {

	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	
	@Before
	public void createProductList(){
		List<Product> productList = new ArrayList<Product>();
		Product product01 = new Product();
		Product product02 = new Product();
		product01.setId(1);
		product01.setProductName("test01");
		product02.setId(2);
		product02.setProductName("test02");
		
		productList.add(product01);
		productList.add(product02);
		
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		
	}
	
	@Test
	public void find_All_Products() {
		List<Product> products = productServiceImpl.findAllProducts();
		assertThat(products.get(0).getId()).isEqualTo(1);
		assertThat(products.get(0).getProductName()).isEqualTo("test01");
		assertThat(products.get(1).getId()).isEqualTo(2);
		assertThat(products.get(1).getProductName()).isEqualTo("test02");
	}
	
	@Before
	public void createProduct01() {
		Product product = new Product();
		product.setId(1);
		product.setProductName("test");
		Mockito.when(productRepository.findOneProductById(product.getId())).thenReturn(product);
	}
	
	@Test
	public void find_One_Product() {
		int id = 1;
		String productName = "test";
		Product foundProduct = productServiceImpl.findOneProduct(id);
		assertThat(foundProduct.getId()).isEqualTo(id);
		assertThat(foundProduct.getProductName()).isEqualTo(productName);

	}
	
	@Before
	public void createProduct02() {
		Product product = new Product();
		product.setId(2);
		product.setProductName("test02");
		Mockito.when(productRepository.findOneByProductName(product.getProductName())).thenReturn(product);
	}

	@Test
	public void find_One_Product_By_Name() {
		String productName = "test02";
		int productId = 2;
		Product foundProduct = productServiceImpl.findOneProductByName(productName);
		assertThat(foundProduct.getProductName()).isEqualTo(productName);
		assertThat(foundProduct.getId()).isEqualTo(productId);
		
	}
}
