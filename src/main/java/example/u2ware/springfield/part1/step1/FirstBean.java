package example.u2ware.springfield.part1.step1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;

@Springfield
@Entity
public class FirstBean {

	@Id @NotNull 
	private @Getter @Setter Integer code;
	
	@NotNull
	private @Getter @Setter String name;
}