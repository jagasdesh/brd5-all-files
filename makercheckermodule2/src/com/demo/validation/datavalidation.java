package com.demo.validation;

import java.util.regex.Pattern;

public class datavalidation {
	
	public static boolean validateLength(String parts) {

		if (parts.length() <= 6) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean validateemail(String parts) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (parts == null)
			System.out.println("email not avalible");
		// System.out.println(parts);
		boolean check = pat.matcher(parts).matches();
		if (check == true) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean RecordStatus(String parts) {

		if (parts.equals("N") || parts.equals("D") || parts.equals("R") || parts.equals("M")
				|| parts.equals("A") == true) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean validDataType(String parts) {
		String datatypeRegex = "^[a-zA-Z0-9\\s]+$";
		Pattern pat = Pattern.compile(datatypeRegex);
		if (parts == null)
			System.out.println("incorrect datatype");

		boolean match = pat.matcher(parts).matches();
		if (match == true) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean RecordAInactive(String parts) {

		if (parts.equals("A") || parts.equals("I") == true) {
			return true;
		} else {
			return false;
		}
	}

}
