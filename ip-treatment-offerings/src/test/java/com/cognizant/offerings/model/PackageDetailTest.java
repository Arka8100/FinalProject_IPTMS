package com.cognizant.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * the class tests all the setters and getters and constructors for the Package
 * Detail
 *
 */
public class PackageDetailTest {

	PackageDetail packageDetail = new PackageDetail();

	@Test
	public void testPackageDetailStringStringIntInt() {
		PackageDetail detail = new PackageDetail("Package 1", "Urology", 1000, 4);
		assertEquals(1000, detail.getCost());
	}

	@Test
	public void testPackageDetail() {
		PackageDetail detail = new PackageDetail();
		detail.setTestDetails("Urology");
		assertEquals("Urology", detail.getTestDetails());
	}

	@Test
	public void testTreatmentPackageName() {
		packageDetail.setTreatmentPackageName("Package 3");
		assertEquals("Package 3", packageDetail.getTreatmentPackageName());
	}

	@Test
	public void testTestDetails() {
		packageDetail.setTestDetails("OPT1,0PT3");
		assertEquals("OPT1,0PT3", packageDetail.getTestDetails());
	}

	@Test
	public void testCost() {
		packageDetail.setCost(5000);
		assertEquals(5000, packageDetail.getCost());
	}

	@Test
	public void testTreatmentDuration() {
		packageDetail.setTreatmentDurationInWeeks(4);
		assertEquals(4, packageDetail.getTreatmentDurationInWeeks());
	}

	@Test
	public void testtoString() {
		String string = packageDetail.toString();
		assertEquals(string, packageDetail.toString());
	}

}
