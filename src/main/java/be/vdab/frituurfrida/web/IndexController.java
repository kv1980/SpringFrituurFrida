package be.vdab.frituurfrida.web;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.valueobjects.Adres;
import be.vdab.frituurfrida.valueobjects.Gemeente;

@Controller
@RequestMapping("/")
class IndexController {
	@GetMapping
	ModelAndView index(@CookieValue(name="reedsBezocht",required=false) String reedsBezocht, HttpServletResponse response) {
		Cookie cookie = new Cookie("ReedsBezocht","ja");
		cookie.setMaxAge(31_536_000);
		response.addCookie(cookie);
		DayOfWeek vandaag = LocalDate.now().getDayOfWeek();
		String openOfGesloten = (vandaag == DayOfWeek.MONDAY || vandaag == DayOfWeek.THURSDAY) ? "gesloten" : "open";
		ModelAndView modelAndView = new ModelAndView("index","openOfGesloten",openOfGesloten)
				.addObject("adres",new Adres("Vlamingstraat","10",new Gemeente("Wevelgem",8560)));
		if (reedsBezocht != null) {
			modelAndView.addObject("reedsBezocht",reedsBezocht);
		}
		return modelAndView;
	}
}
