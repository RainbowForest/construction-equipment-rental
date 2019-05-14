package com.rainbowforest.Application.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.rainbowforest.Application.model.catalog.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product)target;
		
		ValidationUtils.rejectIfEmpty(errors, "productCode", "error.ProductCode.empty");
		ValidationUtils.rejectIfEmpty(errors, "productName", "error.ProductName.empty");
		ValidationUtils.rejectIfEmpty(errors, "productCategory", "error.Category.empty");
		ValidationUtils.rejectIfEmpty(errors, "availability", "error.Availability.empty");
		ValidationUtils.rejectIfEmpty(errors, "productPrice", "error.ProductPrice.empty");

		if(product.getAvailability() <= 0) {
			errors.rejectValue("availability", "error.Availability.isNotMatch");
		}

		if(product.getProductPrice() <= 0) {
			errors.rejectValue("productPrice", "error.ProductPrice.isNotMatch");
		}		
	}
}
