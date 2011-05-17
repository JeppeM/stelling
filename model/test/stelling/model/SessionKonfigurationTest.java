package stelling.model;

import org.junit.Test;

/**
 * Afpr¿ver modelfunktionalitet relateret til systemkonfiguration
 */
public class SessionKonfigurationTest {

	@Test
	public void testSessionKonfiguration() {
		// En controller kreerer en Session ved start
		Session session = new Session();
		// Et konfigurationsobjekt kreeres ved at l¾se et s¾t
		// konfigurationsfiler - men i denne test bruges bare en mock
		// konfiguration defineret nedenfor
		ISessionKonfiguration konfiguration = new MockKonfiguration();
		session.konfigurer(konfiguration);
	}

	private static final class MockKonfiguration implements
			ISessionKonfiguration {

	}
}
