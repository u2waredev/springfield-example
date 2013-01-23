package example.u2ware.springfield.part1.step4.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class ViewBeanControllerTest {

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
	public void testMappingJson() throws Exception{
		this.mockMvc.perform(
				get("/part1/step4.json"))
			.andExpect(status().isOk());
	}
	
/*	@Test
	public void testMappingXml() throws Exception{
		this.mockMvc.perform(
				post("/part1/step4.xml"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testMappingXls() throws Exception{
		this.mockMvc.perform(
				post("/part1/step4.xls"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testMappingDo() throws Exception{
		this.mockMvc.perform(
				get("/part1/step4.do"))
			.andExpect(status().isOk());
	}
	@Test
	public void testMappingJstl() throws Exception{
		this.mockMvc.perform(
				get("/part1/step4.jstl"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testMappingTiles() throws Exception{
		this.mockMvc.perform(
				get("/part1/step4.tiles"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testMappingThymeleaf() throws Exception{
		this.mockMvc.perform(
				get("/part1/step4.thymeleaf"))
			.andExpect(status().isOk());
	}
	
	
	@Test
	public void testMapping() throws Exception{
		this.mockMvc.perform(
				get("/part1/step4"))
			.andExpect(status().isOk());
	}
*/}
