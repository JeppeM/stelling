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
		System.out.print(forespoergsel.beskriv());
		List<Opgave> opgaver = forespoergsel.opgaver();
		Assert.assertEquals(1, opgaver.size());
	}
}
