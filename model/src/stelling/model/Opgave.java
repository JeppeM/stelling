package stelling.model;

/**
 * Repræsenterer en opgave i en forespørgsel, f.eks. en indramning eller en
 * opspænding
 */
public abstract class Opgave implements IBeskrivelig {
	private LaengdeMaal hoejde;
	private LaengdeMaal bredde;

	Opgave() {
		hoejde = LaengdeMaal.NUL;
		bredde = LaengdeMaal.NUL;
	}

	/**
	 * Returnerer højden på opgaven
	 * 
	 * @return Højden på opgaven
	 */
	public LaengdeMaal getHoejde() {
		return hoejde;
	}

	/**
	 * Ændrer højden på opgaven
	 * 
	 * @param inHoejde
	 *            Den nye højde på opgaven
	 */
	public void setHoejde(LaengdeMaal inHoejde) {
		hoejde = inHoejde;
	}

	/**
	 * Returnerer bredden på opgaven
	 * 
	 * @return Bredden på opgaven
	 */
	public LaengdeMaal getBredde() {
		return bredde;
	}

	/**
	 * Ændrer bredden på opgaven
	 * 
	 * @param inBredde
	 *            Den nye bredde på opgaven
	 */
	public void setBredde(LaengdeMaal inBredde) {
		bredde = inBredde;
	}

	@Override
	public final String beskriv() {
		return beskriv("");
	}

	@Override
	public final String beskriv(String linjePrefix) {
		StringBuilder builder = new StringBuilder();
		builder.append(linjePrefix).append(beskrivOpgaveType()).append("\n");
		builder.append(linjePrefix).append("\tMål: ").append(bredde)
				.append(" x ").append(hoejde).append("\n");
		builder.append(beskrivDetaljer(linjePrefix + "\t"));
		return builder.toString();
	}

	/**
	 * Beskriver typen af den implementerede opgave
	 * 
	 * @return Beskrivelse af opgavetypen
	 */
	protected abstract String beskrivOpgaveType();

	/**
	 * Beskriver detaljer vedrørende den implementerende opgave
	 * 
	 * @param linjePrefix
	 *            Prefix som skal sættes foran på alle linjer, der genereres af
	 *            den implementerende klasse
	 * @return Beskrivelse af detaljer vedrørende opgaven
	 */
	protected abstract String beskrivDetaljer(String linjePrefix);
}
