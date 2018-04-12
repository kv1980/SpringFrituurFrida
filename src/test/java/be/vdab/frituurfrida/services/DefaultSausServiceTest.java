package be.vdab.frituurfrida.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.repositories.SausRepository;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSausServiceTest {
	private DefaultSausService service;
	@Mock 
	private SausRepository dummySausRepository;
	private List<Saus> sauzenLijst = Arrays.asList(
			new Saus(1L,"mayonaise", Arrays.asList("olie","eidooier","citroensap","mosterd")),
			new Saus(2L,"cocktail", Arrays.asList("mayonaise","room","ketchup","paprikapoeder","sherry","cognac")),
			new Saus(3L,"mosterd", Arrays.asList("gemalen mosterdzaden","azijn","water")),
			new Saus(4L,"tartare", Arrays.asList("mayonaise","ei","peterselie","sjalot","augurk","kappertjes","bieslook")),
			new Saus(5L,"vinaigrette", Arrays.asList("olijfolie","wijnazijn","mosterd","honing","tuinkruiden"))
			);;
	
	@Before
	public void before() {
		when(dummySausRepository.findAll()).thenReturn(sauzenLijst);
		service = new DefaultSausService(dummySausRepository);
	}
	
	@Test
	public void serviceVindtDeLijstMetSauzen() {
		assertEquals(sauzenLijst,service.findAll());
		verify(dummySausRepository).findAll();
	}
}
