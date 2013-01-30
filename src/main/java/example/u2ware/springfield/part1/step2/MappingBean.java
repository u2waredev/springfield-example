package example.u2ware.springfield.part1.step2;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.SpringfieldId;

@Springfield(
		methodLevelMapping=
			{"*","*.json","*.do","find.xml","find.xls"})
public class MappingBean {

	@SpringfieldId
	private @Getter @Setter Integer code;
	
	private @Getter @Setter String name;
	
}
