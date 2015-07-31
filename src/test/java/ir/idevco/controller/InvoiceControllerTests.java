package ir.idevco.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class InvoiceControllerTests extends ControllerTests {
	@Before
	public void setUp() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void findOne() throws Exception {
		mockMVC.perform(get("/invoice/id/55afc3500b7cb445d5d8da84")).andDo(print());
	}

}
