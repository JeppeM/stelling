package stelling.model;

/**
 * Repr�senterer en opgave i en foresp�rgsel, f.eks. en indramning eller en
 * opsp�nding
 */
public abstract class Opgave implements IBeskrivelig {
	private LaengdeMaal hoejde;
	private LaengdeMaal bredde;

	Opgave() {
		hoejde = LaengdeMaal.NUL;
		bredde = LaengdeMaal.NUL;
	}

	/**
	 * Returnerer h�jden p� opgaven
	 * 
	 * @return H�jden p� opgaven
	 */
	public LaengdeMaal getHoejde() {
		return hoejde;
	}

	/**
	 * �ndrer h�jden p� opgaven
	 * 
	 * @param inHoejde
	 *            Den nye h�jde p� opgaven
	 */
	public void setHoejde(LaengdeMaal inHoejde) {
		hoejde = inHoejde;
	}

	/**
	 * Returnerer bredden p� opgaven
	 * 
	 * @return Bredden p� opgaven
	 */
	public LaengdeMaal getBredde() {
		return bredde;
	}

	/**
	 * �ndrer bredden p� opgaven
	 * 
	 * @param inBredde
	 *            Den nye bredde p� opgaven
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
		builder.append(linjePrefix).append("\tM�l: ").append(bredde)
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
	 * Beskriver detaljer vedr�rende den implementerende opgave
	 * 
	 * @param linjePrefix
	 *            Prefix som skal s�ttes foran p� alle linjer, der genereres af
	 *            den implementerende klasse
	 * @return Beskrivelse af detaljer vedr�rende opgaven
	 */
	protected abstract String beskrivDetaljer(String linjePrefix);
}
