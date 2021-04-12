package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.model.UserToken;

class UserTokenTest {

	UserToken userToken = new UserToken();

	@Test
	public void test_userLoginCredentialTest_String() {
		UserToken userToken = new UserToken("1", "password");
		assertEquals("password", userToken.getAuthToken());

	}

	@Test
	public void test_uPassword() {
		userToken.setAuthToken("password");
		assertEquals("password", userToken.getAuthToken());
	}

	@Test
	public void test_uId() {
		userToken.setUid("1");
		assertEquals("1", userToken.getUid());
	}

}
