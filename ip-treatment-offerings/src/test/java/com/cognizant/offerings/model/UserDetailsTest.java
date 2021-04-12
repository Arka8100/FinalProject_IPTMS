package com.cognizant.offerings.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * the class tests all the setters and getters and constructors for the User
 * Details
 *
 */
public class UserDetailsTest {

	UserDetails userDetails = new UserDetails();

	@Test
	public void testUserDetailString() {
		UserDetails userDetail = new UserDetails(1, "Ron");
		assertEquals("Ron", userDetail.getUserName());

	}

	@Test
	public void testGetName() {
		userDetails.setUserName("Ron");
		assertEquals("Ron", userDetails.getUserName());
	}

	@Test
	public void testSetName() {
		userDetails.setUserName("Ron");
		assertEquals("Ron", userDetails.getUserName());
	}
}
