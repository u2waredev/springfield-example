package example.u2ware.springfield.part1.step1;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.DTO, 
	identity={"code"}
)
public class FirstBean {
	
	private @Getter @Setter Integer code;
	private @Getter @Setter String name;
	
}