package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.model.UserLoginCredential;

class UserLoginCrendentialTest {

	UserLoginCredential userLoginCredential = new UserLoginCredential();

	@Test
	public void test_userLoginCredentialTest_String() {
		UserLoginCredential userLoginCredential = new UserLoginCredential("1", "password");
		assertEquals("password", userLoginCredential.getPassword());

	}

	@Test
	public void test_uPassword() {
		userLoginCredential.setPassword("password");
		assertEquals("password", userLoginCredential.getPassword());
	}

	@Test
	public void test_uId() {
		userLoginCredential.setUid("1");
		assertEquals("1", userLoginCredential.getUid());
	}

}
