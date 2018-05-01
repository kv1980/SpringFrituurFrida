package be.vdab.frituurfrida.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.services.SausService;

public class SauzenControllerTest {
	private SauzenController sauzenController;
	private ModelAndView modelAndView;
	@Mock
	private Woordspel woordspel;

	@Before
	public void before() {
		sauzenController = new SauzenController(Mockito.mock(SausService.class),woordspel);
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
