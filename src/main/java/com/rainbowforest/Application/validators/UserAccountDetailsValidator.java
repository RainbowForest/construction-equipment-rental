package com.rainbowforest.Application.validators;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.rainbowforest.Application.constant.EmailPattern;
import com.rainbowforest.Application.constant.PhonePattern;
import com.rainbowforest.Application.model.user.UserAccount;
import com.rainbowforest.Application.model.user.UserAccountDetails;
import com.rainbowforest.Application.utilities.EmailUtilities;
import com.rainbowforest.Application.utilities.PhoneUtilities;


public class UserAccountDetailsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserAccountDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserAccountDetails userAccountDetails = (UserAccountDetails)target;
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "userAccount.userName", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "userAccount.userPassword", "error.userPassword.empty");
			
		if (!userAccountDetails.getPhoneNumber().equals(null)) {
			boolean isMatch = PhoneUtilities.checkPhone(PhonePattern.PHONE_PATTERN, userAccountDetails.getPhoneNumber());
			if(!isMatch) {
				errors.rejectValue("phoneNumber", "error.phoneNumber.invalidFormat");
			}
		}	
		if(!userAccountDetails.getEmail().equals(null)) {
			boolean isMatch = EmailUtilities.checkEmail(EmailPattern.EMAIL_PATTERN, userAccountDetails.getEmail());
			if (!isMatch) {
				errors.rejectValue("email", "error.email.isNotMatch");
			}
		}
	}
	
	public void isUserNameExist(UserAccount userAccount, BindingResult result) {
		if(userAccount != null) {
			result.rejectValue("userAccount.userName", "error.userNameExist");
		}
	}
}
