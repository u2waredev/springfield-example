package example.u2ware.springfield.part2.step3;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(
	strategy=Strategy.MONGODB,
	entity=MongodbBean.class
)
@QueryMethod("findByIdAndPasswordOrderByContryDesc")
public class MongodbBeanQuery {

	private @Getter @Setter Integer id;
	private @Getter @Setter String password;
}
