package example.u2ware.springfield.part2.step3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Repository;

@Springfield(repository=Repository.JPA)
@Entity
public @ToString @NoArgsConstructor class JpaBean {

	@Id
	@GeneratedValue
	private @Getter @Setter Integer id;

	private @Getter @Setter String password;
	
	private @Getter @Setter String contry;
	
	private @Getter @Setter String address;

	public JpaBean(String password, String contry, String address) {
		super();
		this.password = password;
		this.contry = contry;
		this.address = address;
	}

}