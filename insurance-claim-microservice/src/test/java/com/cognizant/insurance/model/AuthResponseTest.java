package com.cognizant.insurance.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * the class tests all the setters and getters and constructors for the
 * Authorization response
 *
 */
class AuthResponseTest {

	AuthResponse authResponse = new AuthResponse();

	@Test
	void testSetUid() {
		authResponse.setUid("1");
		assertEquals("1", authResponse.getUid());
	}

	@Test
	void testGetUid() {
		authResponse.setUid("1");
		assertEquals("1", authResponse.getUid());
	}

	@Test
	void testSetName() {
		authResponse.setName("Admin");
		assertEquals("Admin", authResponse.getName());
	}

	@Test
	void testGetName() {
		authResponse.setName("Admin");
		assertEquals("Admin", authResponse.getName());
	}

	@Test
	void testSetValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

	@Test
	void testIsValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

	@Test
	void testAuthResponseStringStringBoolean() {
		AuthResponse authrespo = new AuthResponse("1", "Admin", true);
		assertEquals("Admin", authrespo.getName());
	}
}
