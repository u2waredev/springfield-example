package example.u2ware.springfield.part2.step4.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import example.u2ware.springfield.part2.step4.MongodbBean;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MongodbBeanQueryControllerTest {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	protected WebApplicationContext applicationContext;
	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
		logger.debug(mongoOperations.findAll(MongodbBean.class).size());
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
		for(int i = 0 ; i < 10 ; i++){
			this.mockMvc.perform(
					post("/part2/step4/new")
					.param("id", "id"+i)
					.param("password", "pwd"+i)
					.param("contry", "korea")
					.param("address", "addr-"+(10-i)))
				.andExpect(status().isOk());
		}
	}
	@After
	public void afterMongoOperations() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
	}
	
	@Test
	public void testPagingAndOrdring() throws Exception{

		this.mockMvc.perform(get("/part2/step4")
				//.param("id", "id5")
				.param("model_query_pageable.pageNumber" , "0")
				.param("model_query_pageable.pageSize" , "2")
				.param("model_query_pageable.sortOrders[0].property" , "password")
				.param("model_query_pageable.sortOrders[0].direction" , "1")
				.param("model_query_pageable.sortOrders[1].property" , "address")
				.param("model_query_pageable.sortOrders[1].direction" , "-1"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("model_query_result"));
		
	}	
	

}
