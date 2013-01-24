package example.u2ware.springfield.part2.step3.test;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import example.u2ware.springfield.part2.step3.JpaBean;
import example.u2ware.springfield.part2.step3.JpaBeanQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class JpaBeanRepositoryTest {

	protected final Log logger = LogFactory.getLog(getClass());


	@Autowired @Qualifier("jpaBeanRepository")
	private EntityRepository<JpaBean,Integer> hibernateBeanRepository;
	
	@Test
	@Transactional
	public void testWhereAndPagingAndOrdring() throws Exception{
		
		try{
			for(int i = 0 ; i < 10 ; i++){
				hibernateBeanRepository.create(new JpaBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.setPageNumber(0);
		pageable.setPageSize(2);
		pageable.addSortOrder("address", -1);
		
		JpaBeanQuery param = new JpaBeanQuery();
		//param.setId("id7");
		
		Page<JpaBean> entityPage = hibernateBeanRepository.findAll(param, pageable);
		logger.debug(entityPage.getContent());
	}
	
}
