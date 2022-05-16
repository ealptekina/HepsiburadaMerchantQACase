package com.elif.hp.mulakat;
import com.elif.hp.mulakat.Controller.GroceryControler;
import com.elif.hp.mulakat.Model.Grocery;
import com.elif.hp.mulakat.Service.GroceryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(GroceryControler.class)
public class MulakatApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private GroceryService groceryService;


	//test data
	Grocery g1 = new Grocery(1,"apple", 3d, 100);
	Grocery g2 = new Grocery(2,"grapes", 5d, 50);

	@Test
	public void findAll() throws Exception {

		//servis testi
		given(groceryService.findAll()).willReturn(Arrays.asList(g1,g2));

		//web controller testi
		mvc.perform(get("/grocery/")
						.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void findByName() throws Exception{
		given(groceryService.findByName("apple")).willReturn(Arrays.asList(g1,g2).get(0));

		mvc.perform(get("/grocery/findByName/apple")
						.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void putGrocery() throws Exception{

		Grocery g5 = new Grocery();
		g5.setName("limon");
		g5.setPrice(39.50d);
		g5.setStok(20);
		given(groceryService.save(g5)).willReturn(g5);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(g5);

		mvc.perform(post("/grocery/")
						.content(requestJson)
						.contentType(APPLICATION_JSON))
				.andExpect(status().isOk());

	}
}