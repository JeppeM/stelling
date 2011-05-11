package stelling.model;

import junit.framework.Assert;

import org.junit.Test;

public class BeloebTest {

	@Test
	public void testBeloeb() {
		koerTest(0, "0.00");
		koerTest(Beloeb.NUL, "0.00");
		koerTest(100, "100.00");
		koerTest(51.95, "51.95");
	}

	private void koerTest(double vaerdi, String tekst) {
		koerTest(new Beloeb(vaerdi), tekst);
	}

	private void koerTest(Beloeb beloeb, String tekst) {
		Assert.assertTrue(beloeb.toString().equals(tekst));
	}
}
