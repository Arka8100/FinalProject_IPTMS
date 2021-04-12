package com.cognizant.treatments.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * the class tests all the setters and getters and constructors for the Patient
 * Detail
 *
 */
public class PatientDetailTest {

	PatientDetail patientDetail = new PatientDetail();

	@Test
	public void testPatientDetailLongStringIntStringStringString() {
		PatientDetail patientData = new PatientDetail(101, "Harry", 24, "Urology", "Package 1", "10/11/2020");
		assertEquals(101, patientData.getId());

	}

	@Test
	public void testSetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());

	}

	@Test
	public void testGetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());
	}

	@Test
	public void testSetName() {
		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());
	}

	@Test
	public void testGetName() {

		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());

	}

	@Test
	public void testSetAge() {
		patientDetail.setAge(24);
		assertEquals(24, patientDetail.getAge());
	}

	@Test
	public void testGetAge() {
		patientDetail.setAge(24);

		assertEquals(24, patientDetail.getAge());
	}

	@Test
	public void testSetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	@Test
	public void testGetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	@Test
	public void testSetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	@Test
	public void testGetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	@Test
	public void testSetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

	@Test
	public void testGetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

}
