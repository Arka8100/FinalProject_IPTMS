package com.cognizant.treatments.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * the class tests all the setters and getters and constructors for the
 * Treatment Plan
 *
 */
public class TreatmentPlanTest {

	TreatmentPlan treatmentPlan = new TreatmentPlan();

	@Test
	public void testSetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	public void testGetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	public void testSetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	public void testGetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	public void testSetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	public void testGetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	public void testSetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	public void testGetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	public void testSetCost() {
		treatmentPlan.setCost(5000);
		assertEquals(5000, treatmentPlan.getCost());
	}

	@Test
	public void testGetCost() {
		treatmentPlan.setCost(5000);
		assertEquals(5000, treatmentPlan.getCost());
	}

	@Test
	public void testSetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	public void testGetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	public void testSetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	public void testGetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	public void testSetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

	@Test
	public void testGetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

}
