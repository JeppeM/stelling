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
		koerTest(Beloeb.NUL.multiplicer(42), "0.00");
		koerTest(Beloeb.NUL.adder(Beloeb.NUL), "0.00");
		koerTest(new Beloeb(12.5).adder(new Beloeb(17.5)), "30.00");
		koerTest(new Beloeb(12.5).multiplicer(3), "37.50");
	}

	private void koerTest(double vaerdi, String tekst) {
		koerTest(new Beloeb(vaerdi), tekst);
	}

	private void koerTest(Beloeb beloeb, String tekst) {
		Assert.assertTrue(beloeb.toString().equals(tekst));
	}
}
