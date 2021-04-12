package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.model.UserDetail;

class UserDetailTest {

	UserDetail userDetail = new UserDetail();

	@Test
	public void test_UserDetail_String() {
		UserDetail userDetail = new UserDetail("Ron");
		assertEquals("Ron", userDetail.getName());
	}

	@Test
	public void test_GetName() {
		userDetail.setName("Ron");
		assertEquals("Ron", userDetail.getName());
	}


}
