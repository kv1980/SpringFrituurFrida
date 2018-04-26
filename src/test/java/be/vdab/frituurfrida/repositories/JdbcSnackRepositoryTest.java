package be.vdab.frituurfrida.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.frituurfrida.entities.Snack;
import be.vdab.frituurfrida.exceptions.SnackNietGevondenException;


@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcSnackRepository.class)
@Sql("/insertSnack.sql")
public class JdbcSnackRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private JdbcSnackRepository repository;
	
	private long getIdVanTestSnack() {
		return super.jdbcTemplate.queryForObject("select id from snacks where naam='test'",Long.class);
	}
	
	@Test
	public void readBestaandeSnack() {
		assertEquals("test",repository.read(getIdVanTestSnack()).get().getNaam());
	}
	
	@Test
	public void notReadOnbestaandeSnack() {
		assertFalse(repository.read(-1L).isPresent());
	}
	
	@Test
	public void updateBestaandeSnack() {
		Snack testSnack = new Snack(getIdVanTestSnack(),"test",BigDecimal.ONE);
		repository.update(testSnack);
		assertEquals(0,BigDecimal.ONE.compareTo(super.jdbcTemplate.queryForObject("select prijs from snacks where id=?",BigDecimal.class,getIdVanTestSnack())));
	}
	
	@Test (expected = SnackNietGevondenException.class)
	public void notUpdateOnbestaandeSnack() {
		Snack testSnack = new Snack(-1L,"test",BigDecimal.ONE);
		repository.update(testSnack);
	}
	
	@Test
	public void findBestaandeSnackByBeginNaam () {
		List<Snack> snackLijst = repository.findByBeginNaam("t");
		Snack testSnack = new Snack(getIdVanTestSnack(),"test",BigDecimal.TEN);
		int aantalGevondenSnacks = super.countRowsInTableWhere("snacks","naam like 't%'");
		assertEquals(aantalGevondenSnacks,snackLijst.size());
		assertTrue(snackLijst.contains(testSnack)); //contains gebruikt ook equals-method
	}

	@Test
	public void notFindOnbestaandeSnackByNaam () {
		List<Snack> snackLijst = repository.findByBeginNaam("DitIsEenOnbestaandeNaamVoorEenSnack");
		assertEquals(0,snackLijst.size());
	}
}
