package example.u2ware.springfield.part1.step3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;

@Springfield(
	methodLevelMapping=
		{"*","*.json","findForm.xml","findForm.xls","*.do","*.jstl","*.tiles","*.thymeleaf"})
@Entity
public class MappingBean {

	@Id @NotNull 
	private @Getter @Setter Integer code;
	
	@NotNull
	private @Getter @Setter String name;
	
}