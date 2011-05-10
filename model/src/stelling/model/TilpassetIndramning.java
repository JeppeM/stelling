package stelling.model;

/**
 * Repr�senterer en tilpasset indramning
 */
public class TilpassetIndramning extends Indramning {

	@Override
	public String beskriv() {
		return "Tilpasset indramning (" + getBredde() + " x " + getHoejde()
				+ ")";
	}
}
