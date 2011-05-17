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
	private final List<OpgaveType> opgaveTyper;
	private OpgaveType defaultOpgaveType;

	/**
	 * Kreerer en ny session
	 */
	public Session() {
		forespoergsler = new ArrayList<Forespoergsel>();
		opgaveTyper = new ArrayList<OpgaveType>();
		defaultOpgaveType = OpgaveType.BLANK;
	}

	/**
	 * Returnerer de af sessionen underst퓍tede opgavetyper sorteret efter navn
	 * 
	 * @return Opgavetyper sorteret efter navn
	 */
	public List<OpgaveType> opgaveTyper() {
		return Collections.unmodifiableList(opgaveTyper);
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
		forespoergsel.tilfoejOpgave(defaultOpgaveType.nyOpgave());
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

	public void konfigurer(ISessionKonfiguration konfiguration) {
		opgaveTyper.clear();
		opgaveTyper.addAll(OpgaveType.sorterOpgaveTyper(konfiguration
				.opgaveTyper()));
		defaultOpgaveType = konfiguration.defaultOpgaveType();
	}
}
