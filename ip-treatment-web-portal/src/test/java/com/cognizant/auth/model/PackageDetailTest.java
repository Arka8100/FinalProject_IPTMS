package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.model.PackageDetail;

/**
 * 
 * the class tests all the setters and getters and constructors for the Package
 * Detail
 *
 */
public class PackageDetailTest {

	PackageDetail packageDetail = new PackageDetail();

	@Test
	public void test_PackageDetail_StringStringIntInt() {
		PackageDetail detail = new PackageDetail("Package 1", "Urology", 1000, 4);
		assertEquals(1000, detail.getCost());
	}

	@Test
	public void test_PackageDetail() {
		PackageDetail detail = new PackageDetail();
		detail.setTestDetail("Urology");
		assertEquals("Urology", detail.getTestDetail());
	}

	@Test
	public void test_TreatmentPackageName() {
		packageDetail.setTreatmentPackageName("Package 3");
		assertEquals("Package 3", packageDetail.getTreatmentPackageName());
	}

	@Test
	public void test_TestDetails() {
		packageDetail.setTestDetail("OPT1,0PT3");
		assertEquals("OPT1,0PT3", packageDetail.getTestDetail());
	}

	@Test
	public void test_Cost() {
		packageDetail.setCost(5000);
		assertEquals(5000, packageDetail.getCost());
	}

	@Test
	public void test_TreatmentDuration() {
		packageDetail.setTreatmentDurationinWeeks(4);
		assertEquals(4, packageDetail.getTreatmentDurationinWeeks());
	}

	@Test
	public void test_toString() {
		String string = packageDetail.toString();
		assertEquals(string, packageDetail.toString());
	}

}
