package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repræsenterer en forespørgsel på et sæt af opgaver
 */
public class Forespoergsel implements IBeskrivelig {
	private final List<Opgave> opgaver;

	/**
	 * Kreerer ny forespørgsel
	 */
	public Forespoergsel() {
		opgaver = new ArrayList<Opgave>();
	}

	/**
	 * Returnerer de eksisterende opgaver i denne forespørgsel
	 * 
	 * @return Eksisterende opgaver
	 */
	public List<Opgave> opgaver() {
		return Collections.unmodifiableList(opgaver);
	}

	@Override
	public String beskriv() {
		StringBuilder builder = new StringBuilder();
		builder.append("Forespørgsel med følgende opgaver:\n");
		for (Opgave opgave : opgaver) {
			builder.append("\t").append(opgave.beskriv()).append("\n");
		}
		return builder.toString();
	}

	/**
	 * Tilføjer den specificerede opgave til forespørgslen
	 * 
	 * @param opgave
	 *            Opgave der skal tilføjes
	 */
	public void tilfoejOpgave(Opgave opgave) {
		opgaver.add(opgave);
	}
}
