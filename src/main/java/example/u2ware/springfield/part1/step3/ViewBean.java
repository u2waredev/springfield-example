package example.u2ware.springfield.part1.step3;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.SpringfieldId;

@Springfield(
	methodLevelMapping=
		{"*","*.json","*.do","find.xml","find.xls"}, 	
	attributesCSV=
		"webmvc.view.method.find={custom}," +
		"webmvc.view.extension.none={jsonView}," +
		"webmvc.view.extension.do={thymeleafView}")
		//"webmvc.view.springfield={springfield3}"
public class ViewBean {

	@SpringfieldId
	private @Getter @Setter Integer code;
	
	private @Getter @Setter String name;
	
}
