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
}
