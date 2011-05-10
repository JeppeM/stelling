package stelling.model;

/**
 * Repræsenterer et længdemål i millimeter
 */
public class LaengdeMaal {
	private final int vaerdi;

	/**
	 * Længden nul som i visse tilfælde bruges som defaultindstilling
	 */
	public static final LaengdeMaal NUL = new LaengdeMaal(0);

	/**
	 * Kreerer et nyt længdemål
	 * 
	 * @param maal
	 *            Mål i millimeter
	 */
	public LaengdeMaal(int maal) {
		vaerdi = maal;
	}

	/**
	 * Returnerer størrelsen af dette længdemål i millimeter
	 * 
	 * @return Størrelse i millimeter
	 */
	public int vaerdi() {
		return vaerdi;
	}

	@Override
	public String toString() {
		return vaerdi + " mm";
	}
}
