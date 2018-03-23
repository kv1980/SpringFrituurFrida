package be.vdab.frituurfrida.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.Saus;

@Controller
@RequestMapping("sauzen")
public class SauzenController {
	private final static String SAUZEN_JSP = "sauzen";
	private final List<Saus> sauzen = Arrays.asList(
			new Saus(1L,"mayonaise", new String[] {"olie","eidooier","citroensap","mosterd"}),
			new Saus(2L,"cocktail", new String[] {"mayonaise","room","ketchup","paprikapoeder","sherry","cognac"}),
			new Saus(3L,"mosterd", new String[] {"gemalen mosterdzaden","azijn","water"}),
			new Saus(4L,"tartare", new String[] {"mayonaise","ei","peterselie","sjalot","augurk","kappertjes","bieslook"}),
			new Saus(5L,"vinaigrette", new String[] {"olijfolie","wijnazijn","mosterd","honing","tuinkruiden"})
			);
	
	@GetMapping
	ModelAndView sauzen(){
		return new ModelAndView(SAUZEN_JSP,"sauzen",sauzen);
	}
			
}