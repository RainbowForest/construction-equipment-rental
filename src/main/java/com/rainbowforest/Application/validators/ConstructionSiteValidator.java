package com.rainbowforest.Application.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.rainbowforest.Application.constant.ZipCodePattern;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.utilities.ZipCodeUtilities;

public class ConstructionSiteValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ConstructionSite.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ConstructionSite cs = (ConstructionSite)target;
		
		ValidationUtils.rejectIfEmpty(errors, "buildingName", "error.buildingName.empty");
		ValidationUtils.rejectIfEmpty(errors, "buildingCode", "error.buildingCode.empty");
		ValidationUtils.rejectIfEmpty(errors, "constructionSiteAdress.street", "error.streetName.empty");
		ValidationUtils.rejectIfEmpty(errors, "constructionSiteAdress.streetNumber", "error.streetNumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "constructionSiteAdress.locality", "error.locality.empty");
		ValidationUtils.rejectIfEmpty(errors, "constructionSiteAdress.zipCode", "error.zipCode.empty");
		ValidationUtils.rejectIfEmpty(errors, "constructionSiteAdress.country", "error.country.empty");
		
		if(!cs.getConstructionSiteAdress().getZipCode().equals(null)) {
			boolean isMatch = ZipCodeUtilities.checkZipCode(ZipCodePattern.ZIP_CODE_PATTERN, cs.getConstructionSiteAdress().getZipCode());
			if(!isMatch) {
				errors.rejectValue("constructionSiteAdress.zipCode", "error.zipCode.invalidFormat");
			}
		}
	}
}
