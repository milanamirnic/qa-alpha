package com.qaalpha.base;
public class Payloads {
	
	  public static String createUser(String username, String firstname, String lastname, String email, String password) {
	    	return "{\r\n"
				+ "  \"username\": \"" + username + "\",\r\n"
				+ "  \"first_name\": \"" + firstname + "\",\r\n"
				+ "  \"last_name\": \"" + lastname + "\",\r\n"
				+ "  \"email\": \"" + email + "\",\r\n"
				+ " \"password\": \"" + password + "\" \r\n"
				+ "}";
	}
	  	 
	  public static String logIn(String username, String password) {
	    	return "{\r\n"
				+ "  \"username\": \"" + username + "\",\r\n"
				+ " \"password\": \"" + password + "\" \r\n"
				+ "}";
	}
}
