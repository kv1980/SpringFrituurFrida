package be.vdab.frituurfrida.entities;

import java.util.Arrays;

public class Saus {
	private long nummer;
	private String naam;
	private String[] ingrediënten;
	
	public Saus() {
	}

	public Saus(long nummer, String naam, String[] ingrediënten) {
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

	public String[] getIngrediënten() {
		return ingrediënten;
	}

//	public String getIngrediënten() {
//		StringBuilder builder = new StringBuilder();
//		Arrays.stream(ingrediënten).forEach(ingrediënt -> builder.append(", "+ingrediënt));
//		return builder.substring(2).toString();
//	}
	
}
