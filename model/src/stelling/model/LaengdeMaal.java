package stelling.model;

/**
 * Repr�senterer et l�ngdem�l i millimeter
 */
public class LaengdeMaal {
	private final int vaerdi;

	/**
	 * L�ngden nul som i visse tilf�lde bruges som defaultindstilling
	 */
	public static final LaengdeMaal NUL = new LaengdeMaal(0);

	/**
	 * Kreerer et nyt l�ngdem�l
	 * 
	 * @param maal
	 *            M�l i millimeter
	 */
	public LaengdeMaal(int maal) {
		vaerdi = maal;
	}

	/**
	 * Returnerer st�rrelsen af dette l�ngdem�l i millimeter
	 * 
	 * @return St�rrelse i millimeter
	 */
	public int vaerdi() {
		return vaerdi;
	}

	@Override
	public String toString() {
		return vaerdi + " mm";
	}
}
