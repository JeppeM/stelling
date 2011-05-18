package stelling.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
		for (OpgaveType opgaveType : session.opgaveTyper()) {
			System.out.print(opgaveType.nyOpgave().beskriv());
		}
	}

	private static final class MockKonfiguration implements
			ISessionKonfiguration {
		private final List<OpgaveType> opgaveTyper;
		private final OpgaveType defaultOpgaveType;

		public MockKonfiguration() {
			MaterialeType tilpasseligRammeType = new OmkredsPrisMaterialeType(
					"Tilpasselig Ramme");
			MaterialeType faerdigRammeType = new OmkredsPrisMaterialeType(
					"F¾rdigramme");
			MaterialeType glasType = new ArealPrisMaterialeType("Glas");
			MaterialeType bagpapType = new ArealPrisMaterialeType("Bagpap");
			MaterialeType baggrundType = new ArealPrisMaterialeType("Baggrund");
			OpgaveType tilpassetIndramning = new OpgaveType(
					"Tilpasset Indramning",
					Arrays.asList(new IOpgaveAttributType[] {
							tilpasseligRammeType, glasType, bagpapType,
							baggrundType }));
			OpgaveType faerdigIndramning = new OpgaveType("F¾rdigindramning",
					Arrays.asList(new IOpgaveAttributType[] { faerdigRammeType,
							baggrundType }));
			opgaveTyper = Arrays.asList(new OpgaveType[] { tilpassetIndramning,
					faerdigIndramning });
			defaultOpgaveType = tilpassetIndramning;
		}

		@Override
		public Collection<OpgaveType> opgaveTyper() {
			return opgaveTyper;
		}

		@Override
		public OpgaveType defaultOpgaveType() {
			return defaultOpgaveType;
		}
	}
}
