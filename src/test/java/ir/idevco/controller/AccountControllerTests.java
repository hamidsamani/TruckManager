package ir.idevco.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AccountControllerTests extends ControllerTests {

	@Before
	public void setUp() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void accountCreatedSuccessfully() throws Exception {
		mockMVC
				.perform(post("/accounts").content("{\"type\":\"DEPOSIT\",\"amount\":1000000}").contentType("application/json"))
				.andExpect(status().isCreated()).andDo(print());
	}

	@Test
	public void accountsRetrivedSucessfully() throws Exception {
		mockMVC.perform(get("/accounts")).andExpect(status().isOk()).andDo(print());
	}
}
