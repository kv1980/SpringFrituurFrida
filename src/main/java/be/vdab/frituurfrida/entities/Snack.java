package be.vdab.frituurfrida.entities;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Snack {
	private long id;
	@NotBlank
	private String naam;
	@NotNull
	@DecimalMin("0")
	private BigDecimal prijs;

	public Snack() {
	}
	
	public Snack(String naam, BigDecimal prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}

	public Snack(long id, String naam, BigDecimal prijs) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
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

	@Override
	public boolean equals(Object object) {
		if (! (object instanceof Snack)) {
			return false;
		}
		Snack other = (Snack) object;
		return this.naam.equalsIgnoreCase(other.naam);
	}
}