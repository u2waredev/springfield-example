package example.u2ware.springfield.part2.step3;


import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public @ToString class MongodbBean {

	@Id
	@NotNull
	private @Getter @Setter Integer id;
	@NotNull
	private @Getter @Setter String password;
	@NotNull
	private @Getter @Setter String contry;
	@NotNull
	private @Getter @Setter String address;

	public MongodbBean() {

	}
	public MongodbBean(Integer id) {
		this.id = id;
	}
	public MongodbBean(Integer id, String password, String contry, String address) {
		this.id = id;
		this.password = password;
		this.contry = contry;
		this.address = address;
	}
}
