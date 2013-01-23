package example.u2ware.springfield.part1.step4;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;

@Springfield(
	methodLevelMapping=
		{"*","*.json","read.xml","read.xls","*.do","*.jstl","*.tiles","*.thymeleaf"}, 	
	attributesCSV=
		"webmvc.view.method.findForm={custom}," +
		"webmvc.view.extension.none={jsonView},webmvc.view.extension.do={thymeleafView}")
		//"webmvc.view.springfield={springfield3}"
@Entity
public class ViewBean {

	@Id @NotNull 
	private @Getter @Setter Integer code;
	
	@NotNull
	private @Getter @Setter String name;
	
}
