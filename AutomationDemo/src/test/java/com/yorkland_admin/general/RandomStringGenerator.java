package com.yorkland_admin.general;

import java.util.Random;

public class RandomStringGenerator {

	private final static String APHLA_NUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private final static String APHLA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String NUMERIC = "123456789";

	public static String get_random_string(String type, int numberOfDigit) {
		StringBuilder text = new StringBuilder();
		Random rnd = new Random();
		while (text.length() < numberOfDigit) { // length of the random string.
			if (type.equalsIgnoreCase("Aphla")) {
				int index = (int) (rnd.nextFloat() * APHLA.length());
				text.append(APHLA.charAt(index));
			} else if (type.equalsIgnoreCase("Numeric")) {
				int index = (int) (rnd.nextFloat() * NUMERIC.length());
				text.append(NUMERIC.charAt(index));
			} else {
				int index = (int) (rnd.nextFloat() * APHLA_NUMERIC.length());
				text.append(APHLA_NUMERIC.charAt(index));
			}
		}
		String textStr = text.toString();
		return textStr;
	}
}
