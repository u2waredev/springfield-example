package example.u2ware.springfield.part2.step2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
public @ToString class JpaBean {

	@Id
	@GeneratedValue
	private @Getter @Setter Integer id;
	@NotNull
	private @Getter @Setter String password;
	@NotNull
	private @Getter @Setter String contry;
	@NotNull
	private @Getter @Setter String address;

	public JpaBean() {

	}
	public JpaBean(Integer id) {
		this.id = id;
	}
	public JpaBean(String password, String contry, String address) {
		this.password = password;
		this.contry = contry;
		this.address = address;
	}
}