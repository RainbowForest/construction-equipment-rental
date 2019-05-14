package com.rainbowforest.Application.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPriceUtilities {

	public static boolean checkProductPrice(String pattern, double productPrice) {
		String price = String.valueOf(productPrice);
		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(price);
		return match.matches();		
	}
}
