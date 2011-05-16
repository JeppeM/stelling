package stelling.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Repræsenterer en opgave i en forespørgsel, f.eks. en indramning eller en
 * opspænding
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
		builder.append(linjePrefix + "\t").append("Mål: ").append(bredde)
				.append(" x ").append(hoejde).append("\n");
		builder.append(linjePrefix + "\t").append("Pris: ")
				.append(samletPris().toString()).append("\n");
		return builder.toString();
	}
}
