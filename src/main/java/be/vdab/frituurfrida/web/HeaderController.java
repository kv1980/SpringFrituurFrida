package be.vdab.frituurfrida.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("headers")
class HeaderController {
	private final String HEADER_VIEW = "headers";
	@GetMapping
	ModelAndView isNL(@RequestHeader("accept-language") String language) {
		return new ModelAndView(HEADER_VIEW,"isNL",language.toLowerCase().contains("nl"));
	}

}
