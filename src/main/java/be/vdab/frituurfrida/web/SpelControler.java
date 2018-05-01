package be.vdab.frituurfrida.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("spel")
public class SpelControler {
	private final Spel spel;
	private static final String VIEW = "spel";
	private static final String REDIRECT_VIEW = "redirect:/spel";
	
	public SpelControler(Spel spel) {
		this.spel = spel;
	}
	
	@GetMapping
	ModelAndView toonDeuren() {
		return new ModelAndView(VIEW)
				.addObject("deuren",spel.geefAlleDeurenWeer());
	}
	
	@PostMapping("nieuwspel")
	String beginNieuwSpel() {
		spel.reset();
		return REDIRECT_VIEW;
	}
	
	@PostMapping(params = "index")
	String openDeur(int index) {
		spel.openDeur(index);
		return REDIRECT_VIEW;
	}
}