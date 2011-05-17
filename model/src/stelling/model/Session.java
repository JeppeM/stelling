package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * En session repr�senterer hovedindgangen til modellen. En session l�ber fra
 * systemet startes til det lukkes, og det er igennem denne, at klienter kreerer
 * og manipulerer foresp�rgsler
 */
public class Session {
	private final List<Forespoergsel> forespoergsler;
	private final Map<String, OpgaveType> opgaveTyper;

	/**
	 * Kreerer en ny session
	 */
	public Session() {
		forespoergsler = new ArrayList<Forespoergsel>();
		opgaveTyper = new HashMap<String, OpgaveType>();
	}

	/**
	 * Returnerer de af sessionen underst�ttede opgavetyper sorteret efter navn
	 * 
	 * @return Opgavetyper sorteret efter navn
	 */
	public List<OpgaveType> opgaveTyper() {
		return OpgaveType.sorterOpgaveTyper(opgaveTyper.values());
	}

	/**
	 * Returnerer opgavetypen med det specificerede navn
	 * 
	 * @param opgaveTypeNavn
	 *            Navn p� opgavetypen
	 * @return Opgavetypen med det specificerede navn
	 * @exception IllegalArgumentException
	 *                Hvis der ikke findes en opgavetype med det specificerede
	 *                navn
	 */
	public OpgaveType opgaveType(String opgaveTypeNavn) {
		OpgaveType type = opgaveTyper.get(opgaveTypeNavn);
		if (type == null) {
			throw new IllegalArgumentException("Kunne ikke finde en"
					+ " opgavetype med det specificerede navn: "
					+ opgaveTypeNavn);
		}
		return type;
	}

	/**
	 * Returnerer de eksisterende foresp�rgsler i sessionen
	 * 
	 * @return Eksisterende foresp�rgsler
	 */
	public List<Forespoergsel> forespoergsler() {
		return Collections.unmodifiableList(forespoergsler);
	}

	/**
	 * Kreerer en ny foresp�rgsel med en default opgave
	 * 
	 * @return Ny foresp�rgsel
	 */
	public Forespoergsel nyForespoergsel() {
		Forespoergsel forespoergsel = new Forespoergsel();
		Opgave defaultOpgave = nyDefaultOpgave();
		forespoergsel.tilfoejOpgave(defaultOpgave);
		forespoergsler.add(forespoergsel);
		return forespoergsel;
	}

	/**
	 * Fjerner den specificerede foresp�rgsel fra sessionen
	 * 
	 * @param forespoergsel
	 *            Foresp�rgsel der skal fjernes
	 * @exception IllegalArgumentException
	 *                Hvis den specificerede foresp�rgsel ikke findes i
	 *                sessionen
	 */
	public void fjernForespoergsel(Forespoergsel forespoergsel) {
		if (forespoergsler.remove(forespoergsel)) {
			return;
		}
		throw new IllegalArgumentException(
				"Sessionen indeholdt ikke den specificerede foresp�rgsel.");
	}

	/**
	 * Privat utility-funktion, der kreerer en default opgave
	 * 
	 * @return Ny default opgave
	 */
	private static Opgave nyDefaultOpgave() {
		// TODO: H�ndtering af default-opgave
		return new OpgaveType("<default>").nyOpgave();
	}

	public void konfigurer(ISessionKonfiguration konfiguration) {
		// TODO Auto-generated method stub

	}
}
