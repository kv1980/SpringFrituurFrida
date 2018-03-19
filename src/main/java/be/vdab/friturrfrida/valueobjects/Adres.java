package be.vdab.friturrfrida.valueobjects;

public class Adres {
	private String straat;
	private String huisNr;
	private Gemeente gemeente;
	
	public Adres() {
	}

	public Adres(String straat, String huisNr, Gemeente gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.gemeente = gemeente;
	}
	
	public String getStraat() {
		return straat;
	}
	public String getHuisNr() {
		return huisNr;
	}
	public Gemeente getGemeente() {
		return gemeente;
	}

}
