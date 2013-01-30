package example.u2ware.springfield.part2.step2;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(entity=MybatisBean.class, identity={"id"})
@QueryMethod("search")
public class MybatisBeanQuery {

	private @Getter @Setter String id;
	private @Getter @Setter String password;
	
}
