package example.u2ware.springfield.part2.step1;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;

@Springfield(entity=NoRepositoryBean.class)
public class NoRepositoryBeanQuery {

	private @Getter @Setter String id;
	private @Getter @Setter String password;
	
}
