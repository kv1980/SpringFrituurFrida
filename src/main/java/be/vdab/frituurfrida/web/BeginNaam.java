package be.vdab.frituurfrida.web;

import javax.validation.constraints.NotEmpty;

class BeginNaam {
	@NotEmpty
	private String beginNaam;

	public String getBeginNaam() {
		return beginNaam;
	}

	public void setBeginNaam(String beginNaam) {
		this.beginNaam = beginNaam;
	}
}
