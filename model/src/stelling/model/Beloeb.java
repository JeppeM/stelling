package stelling.model;

import java.text.DecimalFormat;

/**
 * Repræsenterer et pengebeløb
 */
public class Beloeb {
	private final double vaerdi;

	/**
	 * Repræsenterer værdien nul
	 */
	public static final Beloeb NUL = new Beloeb(0);

	/**
	 * Kreerer et nyt beløb
	 * 
	 * @param inVaerdi
	 *            Størrelsen på det nye beløb
	 */
	public Beloeb(double inVaerdi) {
		vaerdi = inVaerdi;
	}

	@Override
	public String toString() {
		return new DecimalFormat("0.00").format(vaerdi);
	}
}
