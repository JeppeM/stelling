package stelling.model;

import java.util.Collections;

import junit.framework.Assert;

import org.junit.Test;

public class SessionTest {

	@Test
	public void testSession() {
		Session session = new Session();
		Assert.assertEquals(Collections.emptyList(), session.forespoergsler());
		Forespoergsel forespoergsel1 = session.nyForespoergsel();
		Assert.assertEquals(1, session.forespoergsler().size());
		Forespoergsel forespoergsel2 = session.nyForespoergsel();
		Assert.assertEquals(2, session.forespoergsler().size());
		session.fjernForespoergsel(forespoergsel1);
		Assert.assertEquals(1, session.forespoergsler().size());
		session.fjernForespoergsel(forespoergsel2);
		Assert.assertEquals(Collections.emptyList(), session.forespoergsler());
		try {
			session.fjernForespoergsel(forespoergsel2);
			Assert.fail("Session-klassen tillod sletning af den samme"
					+ " foresp¿rgsel to gange");
		} catch (IllegalArgumentException e) {
			// Forventet opf¿rsel - man kan ikke fjerne den samme foresp¿rgsel
			// flere gange
		}
	}
}
