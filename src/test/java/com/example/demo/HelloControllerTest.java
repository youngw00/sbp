package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

	@Autowired
	MockMvc mock;
	
	@Test
	public void testHello() throws Exception {
		mock.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect((ResultMatcher) content().string("Hello 스피링부트!!"));
		
		MvcResult result = mock.perform(get("/hello"))
				.andExpect(status().isOk())
				.andReturn();
		
		System.out.println("RRR>>"+result.getResponse().getContentAsString());
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
