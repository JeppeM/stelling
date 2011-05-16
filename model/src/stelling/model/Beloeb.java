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

	/**
	 * Returnerer beløbets størrelse som en rå talværdi
	 * 
	 * @return Beløbets størrelse
	 */
	public double vaerdi() {
		return vaerdi;
	}

	/**
	 * Returnerer en ny instans af Beloeb som er multiplum af dette beløb og den
	 * angivne faktor
	 * 
	 * @param faktor
	 *            Faktoren der skal multipliceres med
	 * @return Multipliceret beløb
	 */
	public Beloeb multiplicer(double faktor) {
		return new Beloeb(faktor * vaerdi);
	}

	/**
	 * Returnerer en ny instans af Beloeb som er summen af dette beløb og det
	 * andet beløb
	 * 
	 * @param beloeb
	 *            Beløb der skal lægges til
	 * 
	 * @return Sum af de to beløb
	 */
	public Beloeb adder(Beloeb beloeb) {
		return new Beloeb(vaerdi + beloeb.vaerdi());
	}

	@Override
	public String toString() {
		return new DecimalFormat("0.00").format(vaerdi);
	}
}
