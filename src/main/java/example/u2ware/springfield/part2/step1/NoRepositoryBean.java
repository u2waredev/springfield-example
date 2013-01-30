package example.u2ware.springfield.part2.step1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Repository;
import com.u2ware.springfield.config.SpringfieldId;

@Springfield(repository=Repository.NONE)
public @ToString @NoArgsConstructor @AllArgsConstructor class NoRepositoryBean {

	@SpringfieldId
	private @Getter @Setter String id;

	private @Getter @Setter String password;
	
	private @Getter @Setter String contry;
	
	private @Getter @Setter String address;
	
}
