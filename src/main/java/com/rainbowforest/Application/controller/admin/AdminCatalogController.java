package com.rainbowforest.Application.controller.admin;

import java.util.List;
import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rainbowforest.Application.model.catalog.Product;
import com.rainbowforest.Application.service.product.ProductService;
import com.rainbowforest.Application.validators.ProductValidator;

@Controller
@Secured (value = {"ROLE_ADMIN"})
public class AdminCatalogController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GET
	@RequestMapping("admin/catalog/add-item")
	public String addItem(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "admin/catalog/itemform";
	}
	
	@POST
	@RequestMapping("admin/catalog/save-item")
	public String saveItem(@ModelAttribute("product") Product product, Model model, BindingResult result, Locale locale) {
		String returnPage = null;
		ProductValidator validator = new ProductValidator();
		validator.validate(product, result);
		model.addAttribute("result", result);

		if(result.hasErrors()) {
			model.addAttribute("product", product);
			returnPage = "admin/catalog/itemform";
		}
		else {
			productService.saveProduct(product);
			model.addAttribute("message", messageSource.getMessage("product.save.success", null, locale));
			model.addAttribute("product", new Product());
			returnPage = "admin/catalog/itemform";
		}
		return returnPage;
	}
	
	@GET
	@RequestMapping("admin/catalog/products")
	public String products(Model model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "admin/catalog/products";
	}
	
	@GET
	@RequestMapping("admin/catalog/edit-item")
	public String editItem(@RequestParam ("itemId") int itemId, Model model) {
		Product product = productService.findOneProduct(itemId);
		model.addAttribute("product", product);
		return "admin/catalog/editproduct";
	}
	
	@GET
	@RequestMapping("admin/catalog/product")
	public String product(@RequestParam ("productName") String productName, Model model) {
		Product product = productService.findOneProductByName(productName);
		model.addAttribute("product", product);
		return "admin/catalog/product";
	}
	
	@POST
	@RequestMapping("admin/catalog/update-item")
	public String updateItem(@RequestParam("itemId") int itemId,Product product, Model model) {
		
		productService.updateItem(
				product.getProductCode(), 
				product.getProductName(), 
				product.getProductCategory(), 
				product.getAvailability(), 
				product.getProductPrice(), 
				itemId);
		return "admin/catalog/products";
	}
}
