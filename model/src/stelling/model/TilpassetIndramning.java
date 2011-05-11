package stelling.model;

/**
 * Reprūsenterer en tilpasset indramning
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

	@Override
	public Beloeb samletPris() {
		return Beloeb.NUL;
	}
}
