package example.u2ware.springfield.part2.step1;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public @ToString class MybatisBean {

	@NotNull
	private @Getter @Setter Integer id;
	@NotNull
	private @Getter @Setter String password;
	@NotNull
	private @Getter @Setter String contry;
	@NotNull
	private @Getter @Setter String address;

	public MybatisBean() {

	}
	public MybatisBean(Integer id) {
		this.id = id;
	}
	public MybatisBean(Integer id, String password, String contry, String address) {
		this.id = id;
		this.password = password;
		this.contry = contry;
		this.address = address;
	}
}
