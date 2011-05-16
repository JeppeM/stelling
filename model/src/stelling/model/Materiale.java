package stelling.model;

/**
 * Abstrakt klasse der repr�senterer forskellige typer af materiale, f.eks. en
 * Firenzeramme eller museumsglas
 */
abstract class Materiale {
	private final String navn;

	/**
	 * Kreerer en ny type materiale med det specificerede navn
	 * 
	 * @param inNavn
	 *            Navn p� det nye materiale
	 */
	Materiale(String inNavn) {
		navn = inNavn;
	}

	/**
	 * Returnerer materialets navn
	 * 
	 * @return Navn p� materialet
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer prisen for det valgte materiale i den specificerede st�rrelse.
	 * Klasser der ekstenderer denne abstrakte klasse, m� frit implementere
	 * sammenh�ngen mellem st�rrelse og pris (f.eks. omkreds eller areal)
	 * 
	 * @param h�jde
	 *            H�jden p� opgaven
	 * @param bredde
	 *            Bredden p� opgaven
	 * @return Pris for denne materialetype givet de specificerede m�l
	 */
	public abstract Beloeb pris(LaengdeMaal h�jde, LaengdeMaal bredde);
}
