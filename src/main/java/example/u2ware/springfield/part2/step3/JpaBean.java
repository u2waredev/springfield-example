package example.u2ware.springfield.part2.step3;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Repository;

@Springfield(repository=Repository.JPA)
@Entity
public @ToString @NoArgsConstructor @AllArgsConstructor  class JpaBean {

	@Id
	private @Getter @Setter String id;

	private @Getter @Setter String password;
	
	private @Getter @Setter String contry;
	
	private @Getter @Setter String address;

}