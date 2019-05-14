package com.rainbowforest.Application.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeUtilities {

	public static boolean checkZipCode(String pattern, String zipCode) {
		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(zipCode);
		return match.matches();
	}
}
