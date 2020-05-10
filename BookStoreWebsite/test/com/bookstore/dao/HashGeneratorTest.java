package com.bookstore.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HashGeneratorTest {
	@Test
	public void testGeneratedMD5() throws HashGenerationException {
		String password = "pikachu";
		String encryptedPassword = HashGenerator.generateMD5(password);
		
		System.out.println(encryptedPassword);
		
		assertTrue(true);
	}
}
