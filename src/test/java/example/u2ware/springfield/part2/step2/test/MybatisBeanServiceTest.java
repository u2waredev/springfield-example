package example.u2ware.springfield.part2.step2.test;


import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.domain.EntityPage;
import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.service.EntityService;

import example.u2ware.springfield.part2.step2.MybatisBean;
import example.u2ware.springfield.part2.step2.MybatisBeanQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MybatisBeanServiceTest {

	protected final Log logger = LogFactory.getLog(getClass());

	
	@Before
	@Transactional
	public void before() throws Exception{
		for(int i = 0 ; i < 10 ; i++){
			try{
				mybatisBeanService.create(new MybatisBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
			}catch(Exception e){
				
			}
		}
	}
	
	
	////////////////////////////////
	//
	////////////////////////////////
	@Autowired @Qualifier("mybatisBeanQueryService")
	private EntityService<MybatisBean,MybatisBeanQuery> mybatisBeanService;

	@Test
	public void testOrdring() throws Exception{

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.addSortOrder("address", 1);
		
		MybatisBeanQuery request = new MybatisBeanQuery();

		EntityPage<MybatisBean> entityPage = mybatisBeanService.find(request, pageable);
		logger.debug(entityPage.getTotalElements());
		logger.debug(entityPage.getTotalPages());
		logger.debug(entityPage.getContent().size());
		logger.debug(entityPage.getContent());
		
		Assert.assertEquals(10 , entityPage.getTotalElements());
		Assert.assertEquals("id9", entityPage.getContent().get(0).getId().trim());
	}
	
}
