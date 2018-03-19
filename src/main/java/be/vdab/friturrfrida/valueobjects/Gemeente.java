package be.vdab.friturrfrida.valueobjects;

public class Gemeente {
	private String naam;
	private int postcode;
	
	public Gemeente() {
	}

	public Gemeente(String naam, int postcode) {
		this.naam = naam;
		this.postcode = postcode;
	}

	public String getNaam() {
		return naam;
	}

	public int getPostcode() {
		return postcode;
	}
		
}
