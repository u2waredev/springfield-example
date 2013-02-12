package example.u2ware.springfield.part3.step2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.domain.EntityPage;
import com.u2ware.springfield.domain.EntityPageable;
import com.u2ware.springfield.repository.EntityRepository;
import com.u2ware.springfield.service.EntityServiceImpl;

@Service
public class CustomQueryService extends EntityServiceImpl<Custom, CustomQuery>{

	@Autowired
	public CustomQueryService(
		@Qualifier("customRepository")EntityRepository<Custom, String> r) {
		super("customRepository", r);
	}

	@Override
	@Transactional
	public EntityPage<Custom> findForm(CustomQuery request, EntityPageable pageable) {
		logger.debug("Overide findForm ");
		return super.findForm(request, pageable);
	}
}
