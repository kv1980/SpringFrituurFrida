package be.vdab.frituurfrida.web;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class IndexController {
	@GetMapping
	String index() {
		DayOfWeek vandaag = LocalDate.now().getDayOfWeek();
		return (vandaag == DayOfWeek.MONDAY || vandaag == DayOfWeek.THURSDAY) ? "gesloten" : "open";
	}
}
