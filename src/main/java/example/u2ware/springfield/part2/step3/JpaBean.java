package example.u2ware.springfield.part2.step3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Springfield(type=Type.JPA)
@Entity
public @ToString @NoArgsConstructor @AllArgsConstructor  class JpaBean {

	@Id @NotNull
	private @Getter @Setter String id;

	@NotNull
	private @Getter @Setter String password;
	
	private @Getter @Setter String contry;
	
	private @Getter @Setter String address;

}