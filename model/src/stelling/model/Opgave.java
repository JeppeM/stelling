package stelling.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Repr�senterer en opgave i en foresp�rgsel, f.eks. en indramning eller en
 * opsp�nding
 */
public class Opgave implements IBeskrivelig {
	private final OpgaveType opgaveType;
	private final Map<IOpgaveAttributType, IOpgaveAttribut> materialer;
	private LaengdeMaal hoejde;
	private LaengdeMaal bredde;

	Opgave(OpgaveType inOpgaveType) {
		opgaveType = inOpgaveType;
		materialer = new HashMap<IOpgaveAttributType, IOpgaveAttribut>();
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

	public Beloeb samletPris() {
		// TODO: Udregn prisen fra attributterne
		return Beloeb.NUL;
	}

	@Override
	public final String beskriv() {
		return beskriv("");
	}

	@Override
	public final String beskriv(String linjePrefix) {
		StringBuilder builder = new StringBuilder();
		builder.append(linjePrefix).append(opgaveType.navn()).append("\n");
		builder.append(linjePrefix + "\t").append("M�l: ").append(bredde)
				.append(" x ").append(hoejde).append("\n");
		builder.append(linjePrefix + "\t").append("Pris: ")
				.append(samletPris().toString()).append("\n");
		return builder.toString();
	}
}
