package be.vdab.frituurfrida.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.services.SausService;

@Controller
@RequestMapping("sauzen")
class SauzenController {
	private final static String SAUZEN_JSP = "sauzen";
	private final SausService sausService;
/*	private final List<Saus> sauzen = Arrays.asList(
			new Saus(1L,"mayonaise", Arrays.asList("olie","eidooier","citroensap","mosterd")),
			new Saus(2L,"cocktail", Arrays.asList("mayonaise","room","ketchup","paprikapoeder","sherry","cognac")),
			new Saus(3L,"mosterd", Arrays.asList("gemalen mosterdzaden","azijn","water")),
			new Saus(4L,"tartare", Arrays.asList("mayonaise","ei","peterselie","sjalot","augurk","kappertjes","bieslook")),
			new Saus(5L,"vinaigrette", Arrays.asList("olijfolie","wijnazijn","mosterd","honing","tuinkruiden"))
			);*/
	
	SauzenController(SausService sausService){
		this.sausService = sausService;
	}
	
	@GetMapping
	ModelAndView sauzen(){
		return new ModelAndView(SAUZEN_JSP,"sauzen",sausService.findAll());
	}		
}