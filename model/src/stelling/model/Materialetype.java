package stelling.model;

/**
 * Abstrakt klasse der repr¾senterer forskellige typer af materiale
 */
abstract class Materialetype {
	private final String navn;

	/**
	 * Kreerer en ny materialetype med det specificerede navn
	 * 
	 * @param inNavn
	 *            Navn pŒ den nye materialetype
	 */
	Materialetype(String inNavn) {
		navn = inNavn;
	}

	/**
	 * Returnerer materialetypens navn
	 * 
	 * @return Navn pŒ materialetypen
	 */
	public String navn() {
		return navn;
	}
}
