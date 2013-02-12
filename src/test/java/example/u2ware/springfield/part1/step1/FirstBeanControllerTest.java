package example.u2ware.springfield.part1.step1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="../../application-context.xml")
public class FirstBeanControllerTest {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected WebApplicationContext applicationContext;

	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}
	
	
	//////////////////////////////////////////////////////////
	//
	//////////////////////////////////////////////////////////
	@Test
	public void test9Methods() throws Exception{
		
		this.mockMvc.perform(get("/part1/step1/")).andExpect(status().isOk()); //home

		this.mockMvc.perform(get("/part1/step1/new")).andExpect(status().isOk()); //createForm
		this.mockMvc.perform(post("/part1/step1/new").param("code", "19").param("name", "springfield1")).andExpect(status().isOk()); //create

		this.mockMvc.perform(get("/part1/step1/{code}" , "19")).andExpect(status().isOk()); //read
		
		this.mockMvc.perform(get("/part1/step1/{code}/edit" , "19")).andExpect(status().isOk()); //updateForm
		this.mockMvc.perform(put("/part1/step1/{code}/edit" , "19").param("name", "springfield2")).andExpect(status().isOk()); //update

		this.mockMvc.perform(get("/part1/step1")).andExpect(status().isOk()); //findForm
		this.mockMvc.perform(post("/part1/step1")).andExpect(status().isOk()); //find
		
		this.mockMvc.perform(delete("/part1/step1/{code}/edit" , "19")).andExpect(status().isOk()); //delete
	}
}
