package stelling.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Repræsenterer en opgave i en forespørgsel, f.eks. en indramning eller en
 * opspænding
 */
public class Opgave implements IBeskrivelig {
	private final OpgaveType opgaveType;
	private final Map<IOpgaveAttributType, IOpgaveAttribut> attributter;
	private LaengdeMaal hoejde;
	private LaengdeMaal bredde;

	Opgave(OpgaveType inOpgaveType) {
		opgaveType = inOpgaveType;
		attributter = opgaveType.defaultAttributter();
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

	/**
	 * Returnerer samlet pris for opgaven
	 * 
	 * @return Samlet pris for opgaven
	 */
	public Beloeb samletPris() {
		Beloeb sum = Beloeb.NUL;
		for (IOpgaveAttribut att : attributter.values()) {
			sum = sum.adder(att.pris(hoejde, bredde));
		}
		return sum;
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
		for (IOpgaveAttribut att : attributter.values()) {
			builder.append(linjePrefix + "\t")
					.append(att.attributType().navn()).append(": ")
					.append(att.navn()).append("\n");
		}
		return builder.toString();
	}
}
