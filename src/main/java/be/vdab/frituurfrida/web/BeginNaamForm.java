package be.vdab.frituurfrida.web;

import javax.validation.constraints.NotBlank;

class BeginNaamForm {
	@NotBlank
	private String beginNaam;

	public String getBeginNaam() {
		return beginNaam;
	}

	public void setBeginNaam(String beginNaam) {
		this.beginNaam = beginNaam;
	}
}
