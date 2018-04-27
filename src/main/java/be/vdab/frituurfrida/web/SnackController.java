package be.vdab.frituurfrida.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.Snack;
import be.vdab.frituurfrida.services.SnackService;

@Controller
@RequestMapping("snacks")
class SnackController {
	private static final char[] ALFABET =
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final static String ALFABET_VIEW = "alfabet";
	private final static String BEGINNAAM_VIEW= "beginNaam";
	private final SnackService snackService;
	
	SnackController(SnackService snackService){
		this.snackService = snackService;
	}

	@GetMapping("alfabet")
	ModelAndView alfabet(){
		return new ModelAndView(ALFABET_VIEW, "alfabet", ALFABET);
	}		

	
	@GetMapping("beginnaam")
	ModelAndView snacks() {
		return new ModelAndView(BEGINNAAM_VIEW).addObject(new BeginNaamForm());
	}
	
	@GetMapping(params = "beginletter")
	ModelAndView findByBeginletter(char beginletter) {
		return new ModelAndView(ALFABET_VIEW, "alfabet", ALFABET)
			.addObject("snacks",snackService.findByBeginNaam(String.valueOf(beginletter)));
	}
	
	@GetMapping(params = "beginNaam")
	ModelAndView findByBeginNaam(@Valid BeginNaamForm beginNaamForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BEGINNAAM_VIEW);
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		List<Snack> snacks = snackService.findByBeginNaam(beginNaamForm.getBeginNaam());
		if (snacks.isEmpty()) {
			bindingResult.reject("geensnacks");
		} else {
			modelAndView.addObject("snacks",snacks);
		}
		return modelAndView;
	}
}