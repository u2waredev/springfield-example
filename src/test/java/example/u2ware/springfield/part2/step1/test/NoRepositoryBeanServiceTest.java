package example.u2ware.springfield.part2.step1.test;


import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.u2ware.springfield.domain.EntityPage;
import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.service.EntityService;

import example.u2ware.springfield.part2.step1.NoRepositoryBean;
import example.u2ware.springfield.part2.step1.NoRepositoryBeanQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class NoRepositoryBeanServiceTest {

	protected final Log logger = LogFactory.getLog(getClass());


	@Autowired @Qualifier("noRepositoryBeanQueryService")
	private EntityService<NoRepositoryBean,NoRepositoryBeanQuery> noRepositoryBeanService;
	
	@Test
	public void testOrdring() throws Exception{

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.addSortOrder("address", 1);
		
		NoRepositoryBeanQuery request = new NoRepositoryBeanQuery();
		
		EntityPage<NoRepositoryBean> entityPage = noRepositoryBeanService.find(request, pageable);
		logger.debug(entityPage.getTotalElements());
		logger.debug(entityPage.getTotalPages());
		logger.debug(entityPage.getContent().size());
		logger.debug(entityPage.getContent());
		
		Assert.assertEquals(0 , entityPage.getTotalElements());
	}
	
}
