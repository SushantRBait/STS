package com.sushant.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushant.main.data.User;
import com.sushant.main.data.UserController;
import com.sushant.main.data.UserRepository;

@SpringBootTest
@WebMvcTest(UserController.class)
class SpringBootRestUser1ApplicationTests {

	private UserRepository repo;

	
	@Test
	public void testReadAllUser(){
		List<User> list= repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
}
