package com.rainbowforest.Application.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtilities {

	public static boolean checkEmail(String pattern, String email) {
		Pattern pat = Pattern.compile(pattern);
		Matcher mat = pat.matcher(email);
		return mat.matches();
	}
}
