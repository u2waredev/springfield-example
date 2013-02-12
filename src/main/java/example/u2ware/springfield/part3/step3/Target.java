package example.u2ware.springfield.part3.step3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.JPA_REPOSITORY_ONLY
)
@Entity
public @ToString class Target {

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