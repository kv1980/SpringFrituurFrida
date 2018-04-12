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
	
	SauzenController(SausService sausService){
		this.sausService = sausService;
	}
	
	@GetMapping
	ModelAndView sauzen(){
		return new ModelAndView(SAUZEN_JSP,"sauzen",sausService.findAll());
	}		
}