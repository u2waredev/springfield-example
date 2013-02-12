package example.u2ware.springfield.part2.step1;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(
	strategy=Strategy.SQLSESSION, 
	entity=MybatisBean.class,
	identity={"id"}
)
@QueryMethod("search")
public class MybatisBeanQuery {

	private @Getter @Setter Integer id;
	private @Getter @Setter String password;
}
