package be.vdab.frituurfrida.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.services.SausService;

@Controller
@RequestMapping("sauzen")
class SauzenController {
	private final static String SAUZEN_VIEW = "sauzen";
	private final static String WOORDSPEL_VIEW = "woordspel";
	private final static String REDIRECT_VIEW = "redirect:/sauzen/spel";
	private final SausService sausService;
	private final Woordspel woordspel;
	
	SauzenController(SausService sausService,Woordspel woordspel){
		this.sausService = sausService;
		this.woordspel = woordspel;
	}
	
	@GetMapping
	ModelAndView sauzen(){
		return new ModelAndView(SAUZEN_VIEW,"sauzen",sausService.findAll());
	}
	
	@GetMapping("spel")
	ModelAndView woordspel() {
		return new ModelAndView(WOORDSPEL_VIEW)
				.addObject("woordspel",woordspel)
				.addObject(new WoordspelForm());
	}
	
	@PostMapping("spel/nieuwspel")
	String nieuwWoordspel() {
		woordspel.reset();
		return REDIRECT_VIEW;
	}
	
	@PostMapping(value="spel", params="letter")
	String volgendePogingBijWoordspel(WoordspelForm form) {
		woordspel.raadLetter(form.getLetter());
		return REDIRECT_VIEW;
	}
}