package ir.idevco.controller;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class PaymentControllerTests extends ControllerTests {

	@Before
	public void setUp() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void paymentCreatedSuccessfully() throws Exception {
		mockMVC
				.perform(
						post("/payments").content("{\"title\": \"this is title\", \"description\":\"this is description\"}")
								.contentType(APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void deserializationDateWorksAsExpected() throws Exception {
		mockMVC.perform(post("/payments").content("{\"date\":\"2015-04-19T19:30:00.000Z\"}").contentType(APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void paymentsRetrievedSuccessfully() throws Exception {
		mockMVC.perform(get("/payments")).andExpect(status().isOk()).andDo(print());
	}
}
