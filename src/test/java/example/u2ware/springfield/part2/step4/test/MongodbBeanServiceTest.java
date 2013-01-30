package example.u2ware.springfield.part2.step4.test;


import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.u2ware.springfield.domain.EntityPage;
import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.service.EntityService;

import example.u2ware.springfield.part2.step4.MongodbBean;
import example.u2ware.springfield.part2.step4.MongodbBeanQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MongodbBeanServiceTest {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MongoOperations mongoOperations;

	@Before
	public void before() throws Exception{
		mongoOperations.dropCollection(MongodbBean.class);
		logger.debug(mongoOperations.findAll(MongodbBean.class).size());
		for(int i = 0 ; i < 10 ; i++){
			try{
				mongodbBeanService.create(new MongodbBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
			}catch(Exception e){
				
			}
		}
	}
	@After
	public void afterMongoOperations() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
	}
	
	
	
	
	@Autowired @Qualifier("mongodbBeanQueryService")
	private EntityService<MongodbBean,MongodbBeanQuery> mongodbBeanService;
	
	@Test
	public void testOrdring() throws Exception{

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.addSortOrder("address", 1);
		
		MongodbBeanQuery request = new MongodbBeanQuery();
		
		EntityPage<MongodbBean> entityPage = mongodbBeanService.find(request, pageable);
		logger.debug(entityPage.getTotalElements());
		logger.debug(entityPage.getTotalPages());
		logger.debug(entityPage.getContent().size());
		logger.debug(entityPage.getContent());
		
		Assert.assertEquals(10 , entityPage.getTotalElements());
		Assert.assertEquals("id9", entityPage.getContent().get(0).getId().trim());
	
	}
	


	
}
