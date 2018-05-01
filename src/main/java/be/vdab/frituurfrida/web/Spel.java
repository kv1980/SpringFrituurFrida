package be.vdab.frituurfrida.web;

public interface Spel {
	void openDeur(int index);
	Deur[] geefAlleDeurenWeer();
	void reset();
}
