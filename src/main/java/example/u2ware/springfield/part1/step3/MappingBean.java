package example.u2ware.springfield.part1.step3;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.SpringfieldId;

@Springfield(
	methodLevelMapping=
		{"*","*.json","findForm.xml","findForm.xls","*.do","*.jstl","*.tiles"})
public class MappingBean {

	@SpringfieldId
	private @Getter @Setter Integer code;
	
	private @Getter @Setter String name;
	
}