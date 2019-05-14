package com.rainbowforest.Application.controller.user;

import javax.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.catalog.Product;
import com.rainbowforest.Application.service.product.ProductService;

@Controller
@Secured (value = {"ROLE_ADMIN", "ROLE_USER"})
public class ProductController {

	@Autowired
	private ProductService productService;

	@GET
	@RequestMapping("/catalog")
	public String catalog(Model model) {
		Iterable<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "user/catalog/catalog";
	}
	
	@GET
	@RequestMapping("catalog/search")
	public String findOneProduct(@RequestParam("productName") String productName, Model model) {
		Product product = productService.findOneProductByName(productName);
		model.addAttribute("product", product);
		return "user/catalog/product";
	}
}
