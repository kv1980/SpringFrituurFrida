package be.vdab.frituurfrida.web;

import java.io.Serializable;

public class Deur implements Serializable{
	private static final long serialVersionUID = 1L;
	private boolean open;
	private boolean metFrietjes;
	
	public Deur(boolean metFrietjes) {
		this.metFrietjes = metFrietjes;
	}
	
	public void open() {
		this.open = true;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public boolean isMetFrietjes() {
		return metFrietjes;
	}
}
