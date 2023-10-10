package com.src.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationsTest {

	Validations valid = new Validations();
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Validation check for ID")
	void testCheckId() {
		
		System.out.println("Enter an ID  ");
		String input = sc.next();
		boolean actual = valid.checkId(input);
		boolean expected = true ; 
		assertEquals(actual, expected, "Checking id");
	}

	@Test
	void testCheckPassword() {
		System.out.println("Enter Password  ");
		String input = sc.next();
		boolean actual = valid.checkPassword(input);
		boolean expected = true ; 
		assertEquals(actual, expected, "Checking password");
	}

}
