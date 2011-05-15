package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * En session repr푩enterer hovedindgangen til modellen. En session l풺er fra
 * systemet startes til det lukkes, og det er igennem denne, at klienter kreerer
 * og manipulerer foresp퓊gsler
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
	 * Returnerer de eksisterende foresp퓊gsler i sessionen
	 * 
	 * @return Eksisterende foresp퓊gsler
	 */
	public List<Forespoergsel> forespoergsler() {
		return Collections.unmodifiableList(forespoergsler);
	}

	/**
	 * Kreerer en ny foresp퓊gsel med en default opgave
	 * 
	 * @return Ny foresp퓊gsel
	 */
	public Forespoergsel nyForespoergsel() {
		Forespoergsel forespoergsel = new Forespoergsel();
		Opgave defaultOpgave = nyDefaultOpgave();
		forespoergsel.tilfoejOpgave(defaultOpgave);
		forespoergsler.add(forespoergsel);
		return forespoergsel;
	}

	/**
	 * Fjerner den specificerede foresp퓊gsel fra sessionen
	 * 
	 * @param forespoergsel
	 *            Foresp퓊gsel der skal fjernes
	 * @exception IllegalArgumentException
	 *                Hvis den specificerede foresp퓊gsel ikke findes i
	 *                sessionen
	 */
	public void fjernForespoergsel(Forespoergsel forespoergsel) {
		if (forespoergsler.remove(forespoergsel)) {
			return;
		}
		throw new IllegalArgumentException(
				"Sessionen indeholdt ikke den specificerede foresp퓊gsel.");
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
