package stelling.model;

/**
 * Abstrakt klasse der repræsenterer forskellige typer af materiale, f.eks. en
 * Firenzeramme eller museumsglas
 */
abstract class Materiale {
	private final String navn;

	/**
	 * Kreerer en ny type materiale med det specificerede navn
	 * 
	 * @param inNavn
	 *            Navn på det nye materiale
	 */
	Materiale(String inNavn) {
		navn = inNavn;
	}

	/**
	 * Returnerer materialets navn
	 * 
	 * @return Navn på materialet
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer prisen for det valgte materiale i den specificerede størrelse.
	 * Klasser der ekstenderer denne abstrakte klasse, må frit implementere
	 * sammenhængen mellem størrelse og pris (f.eks. omkreds eller areal)
	 * 
	 * @param højde
	 *            Højden på opgaven
	 * @param bredde
	 *            Bredden på opgaven
	 * @return Pris for denne materialetype givet de specificerede mål
	 */
	public abstract Beloeb pris(LaengdeMaal højde, LaengdeMaal bredde);
}
