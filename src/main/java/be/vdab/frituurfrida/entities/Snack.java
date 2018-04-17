package be.vdab.frituurfrida.entities;

import java.math.BigDecimal;

public class Snack {
	private long id;
	private final String naam;
	private final BigDecimal prijs;
	
	public Snack(long id, String naam, BigDecimal prijs) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
	}

	public Snack(String naam, BigDecimal prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}
	
	public BigDecimal getPrijs() {
		return prijs;
	}
}