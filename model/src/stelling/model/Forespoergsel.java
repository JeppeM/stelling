package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repr�senterer en foresp�rgsel p� et s�t af opgaver
 */
public class Forespoergsel implements IBeskrivelig {
	private final List<Opgave> opgaver;

	/**
	 * Kreerer ny foresp�rgsel
	 */
	public Forespoergsel() {
		opgaver = new ArrayList<Opgave>();
	}

	/**
	 * Returnerer de eksisterende opgaver i denne foresp�rgsel
	 * 
	 * @return Eksisterende opgaver
	 */
	public List<Opgave> opgaver() {
		return Collections.unmodifiableList(opgaver);
	}

	@Override
	public String beskriv() {
		StringBuilder builder = new StringBuilder();
		builder.append("Foresp�rgsel med f�lgende opgaver:\n");
		for (Opgave opgave : opgaver) {
			builder.append("\t").append(opgave.beskriv()).append("\n");
		}
		return builder.toString();
	}

	/**
	 * Tilf�jer den specificerede opgave til foresp�rgslen
	 * 
	 * @param opgave
	 *            Opgave der skal tilf�jes
	 */
	public void tilfoejOpgave(Opgave opgave) {
		opgaver.add(opgave);
	}
}
