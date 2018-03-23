package be.vdab.frituurfrida.web;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.valueobjects.Adres;
import be.vdab.frituurfrida.valueobjects.Gemeente;

@Controller
@RequestMapping("/")
class IndexController {
	@GetMapping
	ModelAndView index() {
		DayOfWeek vandaag = LocalDate.now().getDayOfWeek();
		String openOfGesloten = (vandaag == DayOfWeek.MONDAY || vandaag == DayOfWeek.THURSDAY) ? "gesloten" : "open";
		return new ModelAndView("index","openOfGesloten",openOfGesloten)
				.addObject("adres",new Adres("Vlamingstraat","10",new Gemeente("Wevelgem",8560)));
	}
}
