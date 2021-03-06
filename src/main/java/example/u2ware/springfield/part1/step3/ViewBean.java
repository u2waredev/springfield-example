package example.u2ware.springfield.part1.step3;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.DTO,
	methodLevelMapping={
		"*","*.do",
		"findForm.json","findForm.xml","findForm.xls",
		"read.json","read.xml","read.xls"
	},
	identity={"code"},
	attributesCSV=
		"webmvc.view.method.findForm={custom}," +
		"webmvc.view.extension.none={jstlView}," +
		"webmvc.view.extension.do={thymeleafView}"
		//"webmvc.view.springfield={springfield3}"
)
public class ViewBean {

	private @Getter @Setter Integer code;
	private @Getter @Setter String name;
}
