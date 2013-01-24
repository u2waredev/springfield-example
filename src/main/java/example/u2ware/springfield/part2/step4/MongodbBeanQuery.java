package example.u2ware.springfield.part2.step4;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(entity=MongodbBean.class)
@QueryMethod("findByIdAndPassword")
public class MongodbBeanQuery {

	private @Getter @Setter String id;
	private @Getter @Setter String password;
	
}
