package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * En session repr¾senterer hovedindgangen til modellen. En session l¿ber fra
 * systemet startes til det lukkes, og det er igennem denne, at klienter kreerer
 * og manipulerer foresp¿rgsler
 */
public class Session {
	private final List<Forespoergsel> forespoergsler;

	/**
	 * Kreerer ny session
	 */
	public Session() {
		forespoergsler = new ArrayList<Forespoergsel>();
	}

	/**
	 * Returnerer de eksisterende foresp¿rgsler i sessionen
	 * 
	 * @return Eksisterende foresp¿rgsler
	 */
	public List<Forespoergsel> forespoergsler() {
		return Collections.unmodifiableList(forespoergsler);
	}

	/**
	 * Kreerer en ny foresp¿rgsel med en default opgave
	 * 
	 * @return Ny foresp¿rgsel
	 */
	public Forespoergsel nyForespoergsel() {
		Forespoergsel forespoergsel = new Forespoergsel();
		Opgave defaultOpgave = nyDefaultOpgave();
		forespoergsel.tilfoejOpgave(defaultOpgave);
		forespoergsler.add(forespoergsel);
		return forespoergsel;
	}

	/**
	 * Privat utility-funktion, der kreerer en default opgave
	 * 
	 * @return Ny default opgave
	 */
	private static Opgave nyDefaultOpgave() {
		return new TilpassetIndramning();
	}
}
