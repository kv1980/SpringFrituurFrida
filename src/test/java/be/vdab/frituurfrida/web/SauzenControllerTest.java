package be.vdab.frituurfrida.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class SauzenControllerTest {
	private SauzenController sauzenController;
	private ModelAndView modelAndView;

	@Before
	public void before() {
		sauzenController = new SauzenController();
		modelAndView = sauzenController.sauzen();
	}
	
	@Test
	public void sauzenControllerWerktSamenMetJuisteJSP() {
		assertEquals("sauzen",modelAndView.getViewName());	
	}
	
	@Test
	public void sauzenControllerGeeftSauzenLijstDoorAanJSP() {
		assertTrue(modelAndView.getModel().containsKey("sauzen"));
	}


}
