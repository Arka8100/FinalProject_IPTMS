package com.cognizant.insurance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * the class tests all the setters and getters and constructors for the Initiate
 * Claim
 *
 */
class InitiateClaimTest {

	InitiateClaim initiateClaim = new InitiateClaim();

	@Test
	void testSetId() {
		initiateClaim.setId(101);
		assertEquals(101, initiateClaim.getId());
	}

	@Test
	void testGetId() {
		initiateClaim.setId(101);
		assertEquals(101, initiateClaim.getId());
	}

	@Test
	void testSetPatientName() {
		initiateClaim.setPatientName("Harry");
		assertEquals("Harry", initiateClaim.getPatientName());
	}

	@Test
	void testGetPatientName() {
		initiateClaim.setPatientName("Harry");
		assertEquals("Harry", initiateClaim.getPatientName());
	}

	@Test
	void testSetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology", initiateClaim.getAilment());
	}

	@Test
	void testGetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology", initiateClaim.getAilment());
	}

	@Test
	void testSetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5", initiateClaim.getTreatmentPackageName());
	}

	@Test
	void testGetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5", initiateClaim.getTreatmentPackageName());
	}

	@Test
	void testSetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		assertEquals("XYZ", initiateClaim.getInsurerName());
	}

	@Test
	void testGetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		assertEquals("XYZ", initiateClaim.getInsurerName());
	}
}
