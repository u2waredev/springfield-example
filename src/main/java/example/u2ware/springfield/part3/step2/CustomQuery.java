package example.u2ware.springfield.part3.step2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(
	strategy=Strategy.JPA, 
	entity=Custom.class
)
@QueryMethod("findByIdAndPasswordOrderByCountryDesc")
public @ToString class CustomQuery {
	
	private @Getter @Setter Integer id;
	private @Getter @Setter String password;
}