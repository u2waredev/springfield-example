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
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.repository.EntityRepository;

import example.u2ware.springfield.part2.step4.MongodbBean;
import example.u2ware.springfield.part2.step4.MongodbBeanQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MongodbBeanRepositoryTest {

	protected final Log logger = LogFactory.getLog(getClass());


	@Autowired
	private MongoOperations mongoOperations;

	@Autowired @Qualifier("mongodbBeanRepository")
	private EntityRepository<MongodbBean,Integer> mongodbBeanRepository;

	@Before
	@Transactional
	public void before() throws Exception{
		mongoOperations.dropCollection(MongodbBean.class);
		logger.debug(mongoOperations.findAll(MongodbBean.class).size());
		for(int i = 0 ; i < 10 ; i++){
			mongodbBeanRepository.createOrUpdate(new MongodbBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
		}
	}
	
	@After
	@Transactional
	public void afterMongoOperations() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
	}
	
	@Test
	@Transactional
	public void testWhere() throws Exception{

		EntityPageRequest pageable = new EntityPageRequest();
		
		MongodbBeanQuery param = new MongodbBeanQuery();
		param.setId("id7");

		Page<MongodbBean> page = mongodbBeanRepository.findAll(param, pageable);
		logger.debug(page.getTotalElements());
		logger.debug(page.getContent());
		
		Assert.assertEquals(1 , page.getTotalElements());
		Assert.assertEquals("id7", page.getContent().get(0).getId().trim());
	}
	

}
