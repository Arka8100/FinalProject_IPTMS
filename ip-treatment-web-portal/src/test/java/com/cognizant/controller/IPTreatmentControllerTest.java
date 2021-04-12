package com.cognizant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.Admin;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.service.AuthFeignService;
import com.cognizant.service.PortalService;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class IPTreatmentControllerTest {

	@Mock
	AuthenticationFeign authClient;
	@Mock
	IPTOFClient iPTFOClient;
	@Mock
	IPTFClient iPTFClient;
	@Mock
	ICClient iCClient;

	PortalService pService = new PortalService();
	@Mock
	AuthFeignService feignService;

	private IPTreatmentController iPTreatmentController;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		iPTreatmentController = new IPTreatmentController(authClient, iPTFClient, iPTFOClient, iCClient);
		mockMvc = MockMvcBuilders.standaloneSetup(iPTreatmentController).build();
	}

	@Test
	void testGetLoginPage() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
				.andExpect(MockMvcResultMatchers.status().isOk());

//		Or
//		MvcResult result = this.mockMvc.perform(get("/").header("Authorization", "Bearer Token")).andReturn();
//
//		assertEquals("login2", result.getModelAndView().getViewName());
	}

//	@Test
//	void testGetLogin() throws Exception {
//		Admin user = new Admin("1", "pass", "bhupesh", "token");
//		AuthResponse response = new AuthResponse("1", "bhupesh", true);
//		
//		ResponseEnity
//		
//	}

	@Test
	void testGetLoginFail() throws Exception {
		Admin user = new Admin("Arka", "arka", "Arka", "token");
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("userid", user.getUserid());
		map.put("upassword", user.getUpassword());
		map.put("uname", user.getUname());
		map.put("authToken", user.getAuthToken());
		MvcResult result = this.mockMvc.perform(post("/login").header("Authorization", "Bearer token")).andReturn();
		assertEquals("login", result.getModelAndView().getViewName());
	}

	@Test
	void testGetDashboard() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/admindashboard").header("Authorization", "Bearer Token"))
				.andReturn();
		MvcResult result1 = this.mockMvc
				.perform(get("/admindashboard").header("Authorization", "Bearer token").sessionAttr("token", "token"))
				.andReturn();
		assertEquals("redirect:/", result.getModelAndView().getViewName());
		assertEquals("AdminDashboard2", result1.getModelAndView().getViewName());
	}

	@Test
	void testGetRegister() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/register").param("pId", "1").param("cost", "10000")
				.param("pName", "bhupesh").param("aName", "Urology")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testRegisterPatient() throws Exception {
		PatientDetail pDetail = new PatientDetail(1, "Arka", 35, "Urology", "Package 1", "12/05/2021");
		TreatmentPlan plan = new TreatmentPlan(1, pDetail, "test1", "Package 1", "Dr.Bhupesh Mahakhuda", 2500,
				"InProgress", "12/03/2021", "24/05/2021");
		when(pService.registerPatient("token", pDetail, 10000)).thenReturn(plan);
		when(iPTFClient.formulateTreatmentTimetable("token", pDetail, 2500)).thenReturn(plan);
		mockMvc.perform(MockMvcRequestBuilders.post("/registerSubmit").param("name", "sameer").param("age", "24")
				.param("ailment", "Urology").param("treatmentPackageName", "Package 1").param("cost", "12000"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	void testGetPatients() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTreatmentPlans() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTreatmentPlansNew() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSpecialist() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPackages() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInsurer() {
		fail("Not yet implemented");
	}

	@Test
	void testClaimInsurance() throws Exception {
		when(pService.claimInsurance("token")).thenReturn(Mockito.anyList());
		mockMvc.perform(MockMvcRequestBuilders.get("/claimInsurance").param("id","2").sessionAttr("token","token"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testInitiateClaim() throws Exception {
		
		MvcResult result1 = this.mockMvc
				.perform(post("/initiateClaim").header("Authorization", "Bearer token").sessionAttr("token", "token").param("pId", "admin").param("pckgName", "Package 1"))
				.andReturn();
		assertEquals("final2", result1.getModelAndView().getViewName());
		
	}

	@Test
	void testLogout() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/logout").accept(MediaType.ALL))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}

}
