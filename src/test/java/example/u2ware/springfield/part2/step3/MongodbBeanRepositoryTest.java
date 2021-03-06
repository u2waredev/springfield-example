package example.u2ware.springfield.part2.step3;


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

import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.repository.EntityRepository;

import example.u2ware.springfield.part2.step3.MongodbBean;
import example.u2ware.springfield.part2.step3.MongodbBeanQuery;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="../../application-context.xml")
public class MongodbBeanRepositoryTest {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired @Qualifier("mongodbBeanRepository")
	private EntityRepository<MongodbBean,Integer> mongodbBeanRepository;

	@Before
	public void before() throws Exception{
		mongoOperations.dropCollection(MongodbBean.class);
		for(int i = 1 ; i < 10 ; i++){
			if(! mongodbBeanRepository.exists(new MongodbBean(i), false)){
				mongodbBeanRepository.create(new MongodbBean(i , "pwd"+i, "korea", "addr-"+(10-i)));
			}
		}
	}
	
	
	@Test
	public void testWhere() throws Exception{

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.addSortOrder("address" , 1);

		MongodbBeanQuery param = new MongodbBeanQuery();
		//param.setId(7);

		Page<MongodbBean> page = mongodbBeanRepository.findAll(param, pageable);
		logger.debug(page.getContent().size());
		
		Assert.assertEquals(9 , page.getContent().size());
		Assert.assertEquals(new Integer(9), page.getContent().get(0).getId());
	}
	
	@After
	public void afterMongoOperations() throws Exception {
		mongoOperations.dropCollection(MongodbBean.class);
	}
	
	@Autowired
	private MongoOperations mongoOperations;

}
//Users/admin/IDEs/mongodb-osx-x86_64-2.2.2/bin/mongod --dbpath "/Users/admin/IDEs/mongodb-osx-x86_64-2.2.2/bin/data"

