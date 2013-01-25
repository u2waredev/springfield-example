package example.u2ware.springfield.part1.step2;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.SpringfieldId;

@Springfield
public class SampleBean {

	@SpringfieldId
	private @Getter @Setter Integer code;
	
	private @Getter @Setter String name;
	
}
