package be.vdab.frituurfrida.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.repositories.SausRepository;

public class DefaultSausServiceTest {
	private DefaultSausService service;
	private SausRepository dummySausRepository;
	
	@Before
	public void before() {
		dummySausRepository = Mockito.mock(SausRepository.class);
		Mockito.when(dummySausRepository.findAll())
			   .thenReturn(Arrays.asList(
						new Saus(1L,"mayonaise", Arrays.asList("olie","eidooier","citroensap","mosterd")),
						new Saus(2L,"cocktail", Arrays.asList("mayonaise","room","ketchup","paprikapoeder","sherry","cognac")),
						new Saus(3L,"mosterd", Arrays.asList("gemalen mosterdzaden","azijn","water")),
						new Saus(4L,"tartare", Arrays.asList("mayonaise","ei","peterselie","sjalot","augurk","kappertjes","bieslook")),
						new Saus(5L,"vinaigrette", Arrays.asList("olijfolie","wijnazijn","mosterd","honing","tuinkruiden"))
						));
		service = new DefaultSausService(dummySausRepository);
	}
	
	@Test
	public void serviceVindtEenSaus() {
		Saus saus = new Saus(1L,"mayonaise", Arrays.asList("olie","eidooier","citroensap","mosterd"));
		assertTrue(service.findAll().contains(saus));
		Mockito.verify(dummySausRepository).findAll();
	}
}
