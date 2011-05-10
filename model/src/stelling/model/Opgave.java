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
}
