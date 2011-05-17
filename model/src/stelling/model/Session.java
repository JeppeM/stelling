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
	private final Map<String, MaterialeType> materialeTyper;

	/**
	 * Kreerer en ny session
	 */
	public Session() {
		forespoergsler = new ArrayList<Forespoergsel>();
		materialeTyper = new HashMap<String, MaterialeType>();
	}

	/**
	 * Returnerer de af sessionen understøttede materialetyper sorteret efter
	 * navn
	 * 
	 * @return Materialetyper sorteret efter navn
	 */
	public List<MaterialeType> materialeTyper() {
		return MaterialeType.sorterMaterialeTyper(materialeTyper.values());
	}

	/**
	 * Returnerer materialetypen med det specificerede navn
	 * 
	 * @param materialeTypeNavn
	 *            Navn på materialetypen
	 * @return Materialetypen med det specificerede navn
	 * @exception IllegalArgumentException
	 *                Hvis der ikke findes en materialetype med det
	 *                specificerede navn
	 */
	public MaterialeType materialeType(String materialeTypeNavn) {
		MaterialeType kategori = materialeTyper.get(materialeTypeNavn);
		if (kategori == null) {
			throw new IllegalArgumentException("Kunne ikke finde en"
					+ " materialetype med det specificerede navn: "
					+ materialeTypeNavn);
		}
		return kategori;
	}

	/**
	 * Tilføjer den specificerede materialetype til sessionen. Hvis en
	 * materialetype med samme navn allerede findes i denne session, erstatter
	 * den nye type den gamle med samme navn
	 * 
	 * @param materialeType
	 *            Materialetype som skal tilføjes til sessionen
	 */
	public void tilfoejMaterialetypekategori(MaterialeType materialeType) {
		materialeTyper.put(materialeType.navn(), materialeType);
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
