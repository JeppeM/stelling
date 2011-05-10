package stelling.model;

/**
 * En implementerende klasse kan beskrive sig selv
 */
public interface IBeskrivelig {
	/**
	 * Returnerer en beskrivelse af objektet
	 * 
	 * @return Beskrivelse af objektet
	 */
	public String beskriv();

	/**
	 * Returnerer en beskrivelse af objektet
	 * 
	 * @return Beskrivelse af objektet
	 */
	public String beskriv(String linjePrefix);
}
