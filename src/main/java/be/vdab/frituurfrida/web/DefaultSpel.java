package be.vdab.frituurfrida.web;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
class DefaultSpel implements Spel, Serializable{
	private static final long serialVersionUID = 1L;
	private final Deur[] deuren = new Deur[7];

	public DefaultSpel() {
		reset();
	}

	@Override
	public void openDeur(int index) {
		deuren[index].open();
	}

	@Override
	public Deur[] geefAlleDeurenWeer() {
		return deuren;
	}

	@Override
	public void reset() {
		int indexMetFriet = ThreadLocalRandom.current().nextInt(0,7);
		for (int index = 0; index != 7; index++) {
			deuren[index] = new Deur(index == indexMetFriet);
		}
	}
}
