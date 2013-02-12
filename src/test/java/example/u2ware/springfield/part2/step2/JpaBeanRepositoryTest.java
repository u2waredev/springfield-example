package example.u2ware.springfield.part2.step2;


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

import example.u2ware.springfield.part2.step2.JpaBean;
import example.u2ware.springfield.part2.step2.JpaBeanQuery;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="../../application-context.xml")
public class JpaBeanRepositoryTest {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired @Qualifier("jpaBeanRepository")
	private EntityRepository<JpaBean,Integer> hibernateBeanRepository;

	@Before
	@Transactional
	public void before() throws Exception{
		for(int i = 1 ; i < 10 ; i++){
			if(! hibernateBeanRepository.exists(new JpaBean(i), false)){
				hibernateBeanRepository.create(new JpaBean("pwd"+i, "korea", "addr-"+(10-i)));
			}
		}
	}
	
	
	@Test
	@Transactional
	public void testWhere() throws Exception{
		
		EntityPageRequest pageable = new EntityPageRequest();
		pageable.addSortOrder("address" , 1);
		
		JpaBeanQuery param = new JpaBeanQuery();
		//param.setId(7);
		
		Page<JpaBean> page = hibernateBeanRepository.findAll(param, pageable);
		logger.debug(page.getContent().size());
		
		Assert.assertEquals(9 , page.getContent().size());
		Assert.assertEquals(new Integer(9), page.getContent().get(0).getId());
	}
	
}
