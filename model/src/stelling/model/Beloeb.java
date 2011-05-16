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

	/**
	 * Returnerer bel�bets st�rrelse som en r� talv�rdi
	 * 
	 * @return Bel�bets st�rrelse
	 */
	public double vaerdi() {
		return vaerdi;
	}

	/**
	 * Returnerer en ny instans af Beloeb som er multiplum af dette bel�b og den
	 * angivne faktor
	 * 
	 * @param faktor
	 *            Faktoren der skal multipliceres med
	 * @return Multipliceret bel�b
	 */
	public Beloeb multiplicer(double faktor) {
		return new Beloeb(faktor * vaerdi);
	}

	/**
	 * Returnerer en ny instans af Beloeb som er summen af dette bel�b og det
	 * andet bel�b
	 * 
	 * @param beloeb
	 *            Bel�b der skal l�gges til
	 * 
	 * @return Sum af de to bel�b
	 */
	public Beloeb adder(Beloeb beloeb) {
		return new Beloeb(vaerdi + beloeb.vaerdi());
	}

	@Override
	public String toString() {
		return new DecimalFormat("0.00").format(vaerdi);
	}
}
