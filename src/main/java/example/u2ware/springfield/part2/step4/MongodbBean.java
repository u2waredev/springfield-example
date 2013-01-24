package example.u2ware.springfield.part2.step4;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Type;

@Springfield(type=Type.MONGODB)
public @ToString @NoArgsConstructor @AllArgsConstructor class MongodbBean {

	@Id @NotNull
	private @Getter @Setter String id;

	@NotNull
	private @Getter @Setter String password;
	
	private @Getter @Setter String contry;
	
	private @Getter @Setter String address;
	
}
