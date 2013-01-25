package example.u2ware.springfield.part2.step2;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Type;

@Springfield(type=Type.SQLSESSION)
public @ToString @NoArgsConstructor @AllArgsConstructor class MybatisBean {

	@Id @NotNull
	private @Getter @Setter String id;

	@NotNull
	private @Getter @Setter String password;
	
	private @Getter @Setter String contry;
	
	private @Getter @Setter String address;
	
}