package com.qaalpha.util;

import java.util.Random;
import java.util.UUID;

public class HelperUtil {

	
	public static String getRandomString(int n) { // "static" keyword - no need to create an object before calling a method
		return UUID.randomUUID().toString().substring(0, n);
	}
	
	public static String getRandomNumbers(int randomNumbersCount) {
		String random = "";
		int[] randomNumbers = new int[randomNumbersCount];
		Random number = new Random();
		for (int i = 0; i < randomNumbersCount; i++) {
			randomNumbers[i] = number.nextInt(8) + 1;
		}
		for (int j = 0; j < randomNumbers.length; j++) {
			random += randomNumbers[j];
		}
		return random;
	}
	
	public static String getRandomEmail() {	// helper method for generating random email
		return UUID.randomUUID().toString().substring(0, 5) + "@" + UUID.randomUUID().toString().substring(0, 5)
				+ ".com";
	}
}