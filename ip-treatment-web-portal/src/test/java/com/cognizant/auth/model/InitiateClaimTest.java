package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.model.InitiateClaim;

/**
 * 
 * the class tests all the setters and getters and constructors for the Initiate
 * Claim
 *
 */
class InitiateClaimTest {

	InitiateClaim initiateClaim = new InitiateClaim();

	@Test
	void test_SetId() {
		initiateClaim.setId(101);
		assertEquals(101, initiateClaim.getId());
	}

	@Test
	void test_GetId() {
		initiateClaim.setId(101);
		assertEquals(101, initiateClaim.getId());
	}

	@Test
	void test_SetPatientName() {
		initiateClaim.setPatientName("Harry");
		assertEquals("Harry", initiateClaim.getPatientName());
	}

	@Test
	void test_GetPatientName() {
		initiateClaim.setPatientName("Harry");
		assertEquals("Harry", initiateClaim.getPatientName());
	}

	@Test
	void test_SetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology", initiateClaim.getAilment());
	}

	@Test
	void test_GetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology", initiateClaim.getAilment());
	}

	@Test
	void test_SetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5", initiateClaim.getTreatmentPackageName());
	}

	@Test
	void test_GetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5", initiateClaim.getTreatmentPackageName());
	}

	@Test
	void test_SetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		assertEquals("XYZ", initiateClaim.getInsurerName());
	}

	@Test
	void test_GetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		assertEquals("XYZ", initiateClaim.getInsurerName());
	}

	@Test
	public void test_InitiateClaim_String() {
		InitiateClaim initiateClaim = new InitiateClaim(1, null, null, null, null, null, null, null, null, null, null,
				0, 0, 0, 0, 0, 0);
		assertEquals(1L, initiateClaim.getId());

	}
}
