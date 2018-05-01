package be.vdab.frituurfrida.web;

public interface Woordspel {
	void reset();
	void raadLetter(char letter);
	String getTeRadenSaus();
	String getReedsGeradenLetters();
	int getAantalVerkeerdePogingen();
	boolean isGewonnen();
	boolean isVerloren();
}
