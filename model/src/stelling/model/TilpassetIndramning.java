package stelling.model;

/**
 * Repr¾senterer en tilpasset indramning
 */
public class TilpassetIndramning extends Indramning {

	@Override
	protected String beskrivOpgaveType() {
		return "Tilpasset indramning";
	}

	@Override
	protected String beskrivDetaljer(String linjePrefix) {
		return "";
	}
}
