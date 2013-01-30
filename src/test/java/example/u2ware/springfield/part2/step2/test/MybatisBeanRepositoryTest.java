package example.u2ware.springfield.part2.step2.test;


import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.repository.EntityRepository;

import example.u2ware.springfield.part2.step2.MybatisBean;
import example.u2ware.springfield.part2.step2.MybatisBeanQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MybatisBeanRepositoryTest {

	protected final Log logger = LogFactory.getLog(getClass());

	
	@Autowired @Qualifier("mybatisBeanRepository")
	private EntityRepository<MybatisBean,Integer> mybatisBeanRepository;
	
	@Before
	@Transactional
	public void before() throws Exception{
		for(int i = 0 ; i < 10 ; i++){
			mybatisBeanRepository.createOrUpdate(new MybatisBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
		}
	}

	
	
	@Test
	@Transactional
	public void testWhere() throws Exception{

		EntityPageRequest pageable = new EntityPageRequest();

		MybatisBeanQuery param = new MybatisBeanQuery();
		param.setId("id7");
		
		Page<MybatisBean> page = mybatisBeanRepository.findAll(param, pageable);
		logger.debug(page.getTotalElements());
		logger.debug(page.getContent());
		
		Assert.assertEquals(1 , page.getTotalElements());
		Assert.assertEquals("id7", page.getContent().get(0).getId().trim());
	}
	
	@Test
	@Transactional
	public void testRead() throws Exception{

		MybatisBean param = new MybatisBean();
		param.setId("id7");
		
		MybatisBean page = mybatisBeanRepository.read(param);
		
		logger.debug(page);
		
		
	}
}
