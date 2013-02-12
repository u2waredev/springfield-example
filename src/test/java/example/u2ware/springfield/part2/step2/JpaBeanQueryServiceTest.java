package example.u2ware.springfield.part2.step2;


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

import com.u2ware.springfield.domain.EntityPage;
import com.u2ware.springfield.domain.EntityPageRequest;
import com.u2ware.springfield.service.EntityService;

import example.u2ware.springfield.part2.step2.JpaBean;
import example.u2ware.springfield.part2.step2.JpaBeanQuery;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="../../application-context.xml")
public class JpaBeanQueryServiceTest {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired @Qualifier("jpaBeanQueryService")
	private EntityService<JpaBean,JpaBeanQuery> jpaBeanQueryService;
	
	
	@Before
	public void before() throws Exception{
		for(int i = 1 ; i < 10 ; i++){
			if(jpaBeanQueryService.read(new JpaBean(i)) == null){
				jpaBeanQueryService.create(new JpaBean("pwd"+i, "korea", "addr-"+(10-i)));
			}
		}
	}

	@Test
	public void testOrdring() throws Exception{
		
		EntityPageRequest pageable = new EntityPageRequest();
		pageable.addSortOrder("address", 1);
		
		JpaBeanQuery request = new JpaBeanQuery();
		
		EntityPage<JpaBean> entityPage = jpaBeanQueryService.find(request, pageable);
		logger.debug(entityPage.getTotalElements());
		logger.debug(entityPage.getTotalPages());
		logger.debug(entityPage.getContent().size());
		logger.debug(entityPage.getContent());
		
		Assert.assertEquals(9 , entityPage.getTotalElements());
		Assert.assertEquals(new Integer(9), entityPage.getContent().get(0).getId());
	
	}
	
}
