package stelling.model;

public class OpgaveTypeTest {

	// @Test - sl�et fra i �jeblikket
	public void testTilpassetIndramning() {
		Session session = new Session();

		// Her skal der s� tilf�jes nogle materialetyper til session-objektet

		OpgaveType tilpassetIndramningType = new OpgaveType(
				"TilpassetIndramning");
		MaterialeType tilpassetRammeType = session
				.materialeType("TilpassetRammeType");
		tilpassetIndramningType.tilfoejAttributType(tilpassetRammeType);
		MaterialeType glasType = session.materialeType("GlasType");
		tilpassetIndramningType.tilfoejAttributType(glasType);

		// Efter at alle attributtyper er specificeret kan man kreere en ny
		// opgave s�ledes

		Opgave opgave = tilpassetIndramningType.nyOpgave();
		Beloeb pris = opgave.samletPris();
	}
}
