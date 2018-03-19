package be.vdab.frituurfrida.web;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class IndexController {
	String index() {
		DayOfWeek vandaag = LocalDate.now().getDayOfWeek();
		if (vandaag == DayOfWeek.MONDAY || vandaag == DayOfWeek.THURSDAY) {
			return "gesloten";
		}
		return "open";
	}
}
