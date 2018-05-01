package be.vdab.frituurfrida.web;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.services.SausService;

@Component
@SessionScope
class DefaultWoordspel implements Woordspel, Serializable {
	private static final long serialVersionUID = 1L;
	private static final int MAX_POGINGEN = 10;
	private final SausService sausService;
	private String teRadenSaus;
	private StringBuilder reedsGeradenLetters;
	private int aantalVerkeerdePogingen;
	
	public DefaultWoordspel(SausService sausService) {
		this.sausService = sausService;
		reset();
	}

	@Override
	public void reset() {
		List<Saus> sauzen = sausService.findAll();
		teRadenSaus = sauzen.get(ThreadLocalRandom.current().nextInt(sauzen.size())).getNaam();
		reedsGeradenLetters = new StringBuilder();
		IntStream.rangeClosed(1,teRadenSaus.length())
				 .forEach(teller -> reedsGeradenLetters.append("."));
		aantalVerkeerdePogingen = 0;
	}

	@Override
	public void raadLetter(char letter) {
		int letterindex = teRadenSaus.indexOf(letter);
		if (letterindex == -1) {
			aantalVerkeerdePogingen++;
		} else {
			do {
				reedsGeradenLetters.setCharAt(letterindex,letter);
				letterindex = teRadenSaus.indexOf(letter,letterindex+1);
			} while (letterindex != -1);
		}
	}

	@Override
	public String getTeRadenSaus() {
		return teRadenSaus;
	}

	@Override
	public String getReedsGeradenLetters() {
		return reedsGeradenLetters.toString();
	}

	@Override
	public int getAantalVerkeerdePogingen() {
		return aantalVerkeerdePogingen;
	}

	@Override
	public boolean isGewonnen() {
		return reedsGeradenLetters.indexOf(".") == -1;
	}

	@Override
	public boolean isVerloren() {
		return aantalVerkeerdePogingen == MAX_POGINGEN;
	}
}
