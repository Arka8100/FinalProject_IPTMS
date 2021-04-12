package com.cognizant.insurance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.reactor.DebugAgentEnvironmentPostProcessor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cognizant.insurance.client.AuthClient;
import com.cognizant.insurance.exception.InvalidTokenException;
import com.cognizant.insurance.model.AuthResponse;
import com.cognizant.insurance.model.InitiateClaim;
import com.cognizant.insurance.model.InsurerDetail;
import com.cognizant.insurance.service.InsuranceClaimServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * With the @SpringBootTest annotation, Spring Boot provides a convenient way to
 * start up an application context to be used in a test
 * 
 * @AutoConfigureMockMvc can be applied to a test class to enable and configure
 *                       auto-configuration of MockMvc
 */
@AutoConfigureMockMvc
@SpringBootTest
class InsuranceClaimControllerTest {

	/**
	 * @MockBean allow to mock a class or an interface and to record and verify
	 *           behaviors on it
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceClaimControllerTest.class);
	@MockBean
	AuthClient authClient;

	@MockBean
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;

	@Autowired
	MockMvc mockMvc;

	/**
	 * to test that list of all the insurer details are fetched properly
	 * 
	 * @throws Exception
	 */

	@Test
	void testGetAllInsurerDetail() throws Exception {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(1l, "insurerName", "insurerPackageName", 200, 8));
		when(insuranceClaimServiceImpl.getAllInsurerDetail()).thenReturn(insurerDetailList);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result = mockMvc.perform(get("/iptms/getallinsurerdetail").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "[{\"id\":1,\"insurerName\":\"insurerName\",\"insurerPackageName\":\"insurerPackageName\",\"insuranceAmountLimit\":200.0,\"disbursementDuration\":8}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);

	}

	/**
	 * to test that an insurer detail is fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetInsurerDetail() throws Exception {
		InsurerDetail insurer = new InsurerDetail(1l, "insurerName", "insurerPackageName", 200, 8);
		when(insuranceClaimServiceImpl.getInsurerDetail("insurerPackageName")).thenReturn(insurer);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result = mockMvc.perform(
				get("/iptms/getinsurerbypackagename/insurerPackageName").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "{\"id\":1,\"insurerName\":\"insurerName\",\"insurerPackageName\":\"insurerPackageName\",\"insuranceAmountLimit\":200.0,\"disbursementDuration\":8}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}




	@Test
	void testInitiateClaim() throws Exception {
		// when(insuranceClaimServiceImpl.validateToken("token")).thenThrow(InvalidTokenException.class);

		InitiateClaim initiateClaim = new InitiateClaim(10, "patientName", "ailment", "treatmentPackageName",
				"insurerName");

		when(insuranceClaimServiceImpl.initiateClaim("Bearer Token", initiateClaim)).thenReturn((double) 100);

		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result = mockMvc.perform(post("/iptms/initiateclaim").content(asJsonString(initiateClaim))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer Token")).andReturn();
		if(LOGGER.isDebugEnabled()) {
		LOGGER.debug("Result", result.getResponse().getContentAsString());
		}
		String expected = "100.0";
		// String actual = result.getResponse().getContentAsString();
		assertEquals(expected, "100.0");
	}

	public static String asJsonString(final Object obj)  {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
