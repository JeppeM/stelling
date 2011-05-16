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
	private final Map<String, Materialetypekategori> kategorier;

	/**
	 * Kreerer en ny session
	 */
	public Session() {
		forespoergsler = new ArrayList<Forespoergsel>();
		kategorier = new HashMap<String, Materialetypekategori>();
	}

	/**
	 * Returnerer de af sessionen understøttede materialetypekategorier sorteret
	 * efter navn
	 * 
	 * @return Materialetypekategorier sorteret efter navn
	 */
	public List<Materialetypekategori> materialetypekategorier() {
		return Materialetypekategori.sorterKategorier(kategorier.values());
	}

	/**
	 * Returnerer materialetypekategorien med det specificerede navn
	 * 
	 * @param kategorinavn
	 *            Navn på materialetypekategorien
	 * @return Materialetypekategorien med det specificerede navn
	 * @exception IllegalArgumentException
	 *                Hvis der ikke findes en kategori med det specificerede
	 *                navn
	 */
	public Materialetypekategori materialetypekategori(String kategorinavn) {
		Materialetypekategori kategori = kategorier.get(kategorinavn);
		if (kategori == null) {
			throw new IllegalArgumentException("Kunne ikke finde en"
					+ " kategori med det specificerede navn: " + kategorinavn);
		}
		return kategori;
	}

	/**
	 * Tilføjer den specificerede kategori til sessionen. Hvis en kategori med
	 * samme navn allerede findes i denne session, erstatter den nye kategori
	 * den gamle med samme navn
	 * 
	 * @param kategori
	 *            Kategori som skal tilføjes til sessionen
	 */
	public void tilfoejMaterialetypekategori(Materialetypekategori kategori) {
		kategorier.put(kategori.navn(), kategori);
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
		return new Opgave() {

			@Override
			public Beloeb samletPris() {
				return Beloeb.NUL;
			}

			@Override
			protected String beskrivOpgaveType() {
				return "<default>";
			}

			@Override
			protected String beskrivDetaljer(String linjePrefix) {
				return "";
			}
		};
	}
}
