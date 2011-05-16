package stelling.model;

/**
 * Abstrakt klasse der repr�senterer forskellige typer af materiale
 */
abstract class Materialetype {
	private final String navn;

	/**
	 * Kreerer en ny materialetype med det specificerede navn
	 * 
	 * @param inNavn
	 *            Navn p� den nye materialetype
	 */
	Materialetype(String inNavn) {
		navn = inNavn;
	}

	/**
	 * Returnerer materialetypens navn
	 * 
	 * @return Navn p� materialetypen
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer prisen for den valgte materialetype i den specificerede
	 * st�rrelse. Klasser der ekstenderer denne abstrakte klasse, m� frit
	 * implementere sammenh�ngen mellem st�rrelse og pris (f.eks. omkreds eller
	 * areal)
	 * 
	 * @param h�jde
	 *            H�jden p� opgaven
	 * @param bredde
	 *            Bredden p� opgaven
	 * @return Pris for denne materialetype givet de specificerede m�l
	 */
	public abstract Beloeb pris(LaengdeMaal h�jde, LaengdeMaal bredde);
}
