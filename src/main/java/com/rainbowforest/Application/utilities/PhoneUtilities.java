package com.rainbowforest.Application.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtilities {

	public static boolean checkPhone(String pattern, String phoneNo) {
		Pattern pat = Pattern.compile(pattern);
		Matcher mat = pat.matcher(phoneNo);
		return mat.matches();
	}	
}
