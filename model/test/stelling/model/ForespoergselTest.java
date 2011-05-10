package stelling.model;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Afpr¿ver basal funktionalitet i klassen Forespoergsel
 */
public class ForespoergselTest {
	private Session session;

	@Before
	public void startUp() {
		session = new Session();
	}

	@Test
	public void testNyForespoergsel() {
		Forespoergsel forespoergsel = session.nyForespoergsel();
		udskrivBeskrivelig(forespoergsel);
		List<Opgave> opgaver = forespoergsel.opgaver();
		Assert.assertEquals(1, opgaver.size());
	}

	@Test
	public void testForespoergselMedFlereOpgaver() {
		Forespoergsel forespoergsel = session.nyForespoergsel();
		udskrivBeskrivelig(forespoergsel);
		Opgave faerdigindramning = new Faerdigindramning();
		forespoergsel.tilfoejOpgave(faerdigindramning);
		udskrivBeskrivelig(forespoergsel);
	}

	/**
	 * Hj¾lpemetode til at udskrive et objekt, der kan beskrive sig selv
	 * 
	 * @param beskrivelig
	 */
	private void udskrivBeskrivelig(IBeskrivelig beskrivelig) {
		System.out.print(beskrivelig.beskriv());
		System.out.println();
	}
}
