package example.u2ware.springfield.part3.step3;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.domain.EntityPage;
import com.u2ware.springfield.domain.EntityPageImpl;
import com.u2ware.springfield.domain.EntityPageable;
import com.u2ware.springfield.repository.EntityRepository;
import com.u2ware.springfield.service.EntityService;

@Service
@Transactional
public class FormService implements EntityService<Form, Form>{

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired 
    @Qualifier("targetRepository")
    private EntityRepository<Target, String> targetRepository;

	public Form home(Form query) {
		return query;
	}

	public EntityPage<Form> findForm(Form query, EntityPageable pageable) {
		return find(query, pageable);
	}

	public List<Form> findForm(Form query) {
		return find(query);
	}

	public EntityPage<Form> find(Form query, EntityPageable pageable) {
		Page<Target> page = targetRepository.findAll(query, pageable);
		logger.debug("===========");
		logger.debug(page.getSize());
		logger.debug(page.getTotalElements());
		logger.debug(page.getContent());

		
		logger.debug("===========");
		List<Form> content = new ArrayList<Form>();
		for(Target target : page.getContent()){
			content.add(new Form(target));
		}
		Page<Form> result = new PageImpl<Form>(content, pageable, page.getTotalElements());
		return new EntityPageImpl<Form>(result);
	}

	public List<Form> find(Form query) {
		List<Target> list = targetRepository.findAll(query);
		List<Form> result = new ArrayList<Form>();
		for(Target target : list){
			result.add(new Form(target));
		}
		return result;
	}

	public Form read(Form entity) {
		targetRepository.read(entity.convert());
		return entity;
	}

	public Form createForm(Form entity) {
		return entity;
	}

	public Form create(Form entity) {
		targetRepository.create(entity.convert());
		return entity;
	}

	public Form updateForm(Form entity) {
		return entity;
	}

	public Form update(Form entity) {
		targetRepository.update(entity.convert());
		return entity;
	}

	public Form delete(Form entity) {
		targetRepository.delete(entity.convert());
		return entity;
	}
}