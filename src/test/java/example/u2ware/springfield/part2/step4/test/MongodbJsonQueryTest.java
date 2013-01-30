package example.u2ware.springfield.part2.step4.test;


import java.util.List;

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
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.repository.EntityRepository;

import example.u2ware.springfield.part2.step4.MongodbBean;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MongodbJsonQueryTest {

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

		
		List<MongodbBean> list1 = mongodbBeanRepository.findAll("{id : 'id1'}");
		logger.debug(list1);

		List<MongodbBean> list4 = mongodbBeanRepository.findAll("{id : { $gt : 'id2'}}");
		for(MongodbBean e : list4){
			logger.debug(e);
		}
		
		List<MongodbBean> list5 = mongodbBeanRepository.findAll("{id : { $lt : 'id6'}}");
		for(MongodbBean e : list5){
			logger.debug(e);
		}
		
		List<MongodbBean> list6 = mongodbBeanRepository.findAll("{id : { $gt : 'id2' , $lt : 'id6' }}");
		for(MongodbBean e : list6){
			logger.debug(e);
		}

		List<MongodbBean> list2 = mongodbBeanRepository.findAll("{$or : [ {id : { $gt : 'id4'}} , {id : {$lt : 'id2'} } ] }");
		for(MongodbBean e : list2){
			logger.debug(e);
		}
		
	}
	

}
