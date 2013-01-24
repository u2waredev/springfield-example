package example.u2ware.springfield.part2.step4.test;


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


	@Autowired @Qualifier("mongodbBeanRepository")
	private EntityRepository<MongodbBean,Integer> mongodbBeanRepository;

	@Test
	@Transactional
	public void testWhereAndPagingAndOrdring() throws Exception{

		try{
			for(int i = 0 ; i < 10 ; i++){
				mongodbBeanRepository.create(new MongodbBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.setPageNumber(0);
		pageable.setPageSize(2);
		pageable.addSortOrder("address", -1);
		
		MongodbBeanQuery param = new MongodbBeanQuery();
		//param.setId("id7");

		Page<MongodbBean> entityPage = mongodbBeanRepository.findAll(param, pageable);
		logger.debug(entityPage.getContent());
	}
	
	@Autowired
	private MongoOperations mongoOperations;


	@Before
	public void beforeMongoOperations() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
		logger.debug(mongoOperations.findAll(MongodbBean.class).size());
	}
	@After
	public void afterMongoOperations() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
	}
}
