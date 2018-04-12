package be.vdab.frituurfrida.entities;

import java.util.List;

public class Saus {
	private long nummer;
	private String naam;
	private List<String> ingrediënten;
	
	public Saus() {
	}

	public Saus(long nummer, String naam, List<String> ingrediënten) {
		this.nummer = nummer;
		this.naam = naam;
		this.ingrediënten = ingrediënten;
	}

	public long getNummer() {
		return nummer;
	}

	public String getNaam() {
		return naam;
	}

	public List<String> getIngrediënten() {
		return ingrediënten;
	}
}
