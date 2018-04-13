package be.vdab.frituurfrida.repositories;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.frituurfrida.entities.Saus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesRepositoryTest {
	@Autowired private PropertiesSausRepository repository;
	
	@Test
	public void PropertiesRepositoryMoetEenLijstVinden() {
		assertTrue(repository.findAll() instanceof List<?>);
	}
	
	@Test
	public void PropertiesRepositoryMoetEenLijstMetMinstensEenElementVinden() {
		assertTrue(repository.findAll().size()>0);
	}
	
	@Test
	public void PropertiesRepositoryMoetEenLijstMetSauzenVinden() {
		repository.findAll().stream().forEach(saus -> assertTrue(saus instanceof Saus));
	}
}