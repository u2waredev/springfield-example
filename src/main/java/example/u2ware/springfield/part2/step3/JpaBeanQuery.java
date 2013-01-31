package example.u2ware.springfield.part2.step3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(entity=JpaBean.class)
@QueryMethod("findByIdAndPassword")
public @ToString class JpaBeanQuery {
	
	private @Getter @Setter Integer id;
	private @Getter @Setter String password;
	
}
