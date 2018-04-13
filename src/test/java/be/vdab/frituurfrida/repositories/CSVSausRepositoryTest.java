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
public class CSVSausRepositoryTest {
	@Autowired private CSVSausRepository repository;
	
	@Test
	public void CSVRepositoryMoetEenLijstVinden() {
		assertTrue(repository.findAll() instanceof List<?>);
	}
	
	@Test
	public void CSVRepositoryMoetEenLijstMetMinstensEenElementVinden() {
		assertTrue(repository.findAll().size()>0);
	}
	
	@Test
	public void CSVRepositoryMoetEenLijstMetSauzenVinden() {
		repository.findAll().stream().forEach(saus -> assertTrue(saus instanceof Saus));
	}
}
