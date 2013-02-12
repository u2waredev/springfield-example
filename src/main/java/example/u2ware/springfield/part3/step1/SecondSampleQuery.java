package example.u2ware.springfield.part3.step1;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;
import com.u2ware.springfield.repository.QueryMethod;

@Springfield(
	strategy=Strategy.JPA,
	entity=Sample.class,
	topLevelMapping="/part3/step12"
)
@QueryMethod("findByAddressOrderByCountryDesc")
public class SecondSampleQuery {
	
	private @Getter @Setter String address;
}
