package example.u2ware.springfield.part3.step2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
public @ToString class Custom {

	@Id
	@NotNull
	private @Getter @Setter String id;
	@NotNull
	private @Getter @Setter String password;
	@NotNull
	private @Getter @Setter String country;
	@NotNull
	private @Getter @Setter String address;
}