package stelling.model;

/**
 * Repr�senterer en specifik type af materiale, f.eks. en Firenzeramme eller
 * museumsglas
 */
public class Materiale implements IOpgaveAttribut {
	private final MaterialeType type;
	private final String navn;
	private final Beloeb pris;

	/**
	 * Kreerer en ny type materiale
	 * 
	 * @param materialeType
	 *            Type af det nye materiale
	 * @param inNavn
	 *            Navn p� det nye materiale
	 * @param inPris
	 *            Pris p� det nye materiale
	 */
	Materiale(MaterialeType inType, String inNavn, Beloeb inPris) {
		type = inType;
		navn = inNavn;
		pris = inPris;
	}

	/**
	 * Returnerer materialets navn
	 * 
	 * @return Navn p� materialet
	 */
	@Override
	public String navn() {
		return navn;
	}

	@Override
	public Beloeb pris(LaengdeMaal hoejde, LaengdeMaal bredde) {
		return type.beregnPris(hoejde, bredde, pris);
	}

	@Override
	public IOpgaveAttributType attributType() {
		return type;
	}
}
