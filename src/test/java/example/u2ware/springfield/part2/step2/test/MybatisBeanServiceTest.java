package example.u2ware.springfield.part2.step2.test;


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

import example.u2ware.springfield.part2.step2.MybatisBean;
import example.u2ware.springfield.part2.step2.MybatisBeanQuery;
import example.u2ware.springfield.part2.step3.JpaBean;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:example/u2ware/springfield/application-context.xml")
public class MybatisBeanServiceTest {

	protected final Log logger = LogFactory.getLog(getClass());

	
	@Autowired @Qualifier("mybatisBeanService")
	private EntityService<MybatisBean,MybatisBeanQuery> mybatisBeanService;
	
	@Test
	public void testWhereAndPagingAndOrdring() throws Exception{

		try{
			for(int i = 0 ; i < 10 ; i++){
				mybatisBeanService.create(new MybatisBean("id"+i , "pwd"+i, "korea", "addr-"+(10-i)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		EntityPageRequest pageable = new EntityPageRequest();
		pageable.setPageNumber(0);
		pageable.setPageSize(2);
		pageable.addSortOrder("address", -1);
		
		MybatisBeanQuery request = new MybatisBeanQuery();
		//request.setId("id7");
		
		@SuppressWarnings("unchecked")
		EntityPage<JpaBean> result = (EntityPage<JpaBean>)mybatisBeanService.find(request, pageable);
		logger.debug(result.getTotalElements());
		logger.debug(result.getTotalPages());
		logger.debug(result.getContent());
	}
	
}
