package example.u2ware.springfield.part3.step3;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.DTO,
	identity={"keyword"}
)
public class Form {

	private @Getter @Setter String keyword;
	
	public Form(){
	}
	public Form(Target target){
		this.convert(target);
	}
	public void convert(Target target){
		this.setKeyword(target.getId().replace("Id", ""));
	}
	public Target convert(){
		Target target = new Target();
		target.setId(keyword+"Id");
		target.setPassword(keyword+"Password");
		target.setCountry(keyword+"Country");
		target.setAddress(keyword+"Address");
		return target;
	}
}
