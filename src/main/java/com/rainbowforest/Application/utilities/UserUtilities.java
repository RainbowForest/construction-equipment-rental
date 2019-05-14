package com.rainbowforest.Application.utilities;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtilities {

	/**
	 * Checks the currently logged in user and returns its name
	 * 
	 * @return  returns the name of the logged in user
	 */
	public static String getLoggedUser() {
		String loggedUser = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			loggedUser = auth.getName();
		}
		return loggedUser;
	}	
}
