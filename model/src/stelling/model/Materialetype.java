package stelling.model;

/**
 * Abstrakt klasse der repræsenterer forskellige typer af materiale
 */
abstract class Materialetype {
	private final String navn;

	/**
	 * Kreerer en ny materialetype med det specificerede navn
	 * 
	 * @param inNavn
	 *            Navn på den nye materialetype
	 */
	Materialetype(String inNavn) {
		navn = inNavn;
	}

	/**
	 * Returnerer materialetypens navn
	 * 
	 * @return Navn på materialetypen
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer prisen for den valgte materialetype i den specificerede
	 * størrelse. Klasser der ekstenderer denne abstrakte klasse, må frit
	 * implementere sammenhængen mellem størrelse og pris (f.eks. omkreds eller
	 * areal)
	 * 
	 * @param højde
	 *            Højden på opgaven
	 * @param bredde
	 *            Bredden på opgaven
	 * @return Pris for denne materialetype givet de specificerede mål
	 */
	public abstract Beloeb pris(LaengdeMaal højde, LaengdeMaal bredde);
}
