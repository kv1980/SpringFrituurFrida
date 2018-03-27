package be.vdab.frituurfrida.entities;

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
}
