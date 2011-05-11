package stelling.model;

import java.text.DecimalFormat;

/**
 * Repr�senterer et pengebel�b
 */
public class Beloeb {
	private final double vaerdi;

	/**
	 * Repr�senterer v�rdien nul
	 */
	public static final Beloeb NUL = new Beloeb(0);

	/**
	 * Kreerer et nyt bel�b
	 * 
	 * @param inVaerdi
	 *            St�rrelsen p� det nye bel�b
	 */
	public Beloeb(double inVaerdi) {
		vaerdi = inVaerdi;
	}

	@Override
	public String toString() {
		return new DecimalFormat("0.00").format(vaerdi);
	}
}
