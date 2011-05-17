package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * En session repræsenterer hovedindgangen til modellen. En session løber fra
 * systemet startes til det lukkes, og det er igennem denne, at klienter kreerer
 * og manipulerer forespørgsler
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
	 * Returnerer de af sessionen understøttede opgavetyper sorteret efter navn
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
	 *            Navn på opgavetypen
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
	 * Returnerer de eksisterende forespørgsler i sessionen
	 * 
	 * @return Eksisterende forespørgsler
	 */
	public List<Forespoergsel> forespoergsler() {
		return Collections.unmodifiableList(forespoergsler);
	}

	/**
	 * Kreerer en ny forespørgsel med en default opgave
	 * 
	 * @return Ny forespørgsel
	 */
	public Forespoergsel nyForespoergsel() {
		Forespoergsel forespoergsel = new Forespoergsel();
		Opgave defaultOpgave = nyDefaultOpgave();
		forespoergsel.tilfoejOpgave(defaultOpgave);
		forespoergsler.add(forespoergsel);
		return forespoergsel;
	}

	/**
	 * Fjerner den specificerede forespørgsel fra sessionen
	 * 
	 * @param forespoergsel
	 *            Forespørgsel der skal fjernes
	 * @exception IllegalArgumentException
	 *                Hvis den specificerede forespørgsel ikke findes i
	 *                sessionen
	 */
	public void fjernForespoergsel(Forespoergsel forespoergsel) {
		if (forespoergsler.remove(forespoergsel)) {
			return;
		}
		throw new IllegalArgumentException(
				"Sessionen indeholdt ikke den specificerede forespørgsel.");
	}

	/**
	 * Privat utility-funktion, der kreerer en default opgave
	 * 
	 * @return Ny default opgave
	 */
	private static Opgave nyDefaultOpgave() {
		// TODO: Håndtering af default-opgave
		return new OpgaveType("<default>").nyOpgave();
	}

	public void konfigurer(ISessionKonfiguration konfiguration) {
		// TODO Auto-generated method stub

	}
}
