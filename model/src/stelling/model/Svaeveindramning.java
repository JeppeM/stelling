package stelling.model;

/**
 * Repr�senterer en sv�veindramningsopgave
 */
public class Svaeveindramning extends Indramning {

	@Override
	protected String beskrivOpgaveType() {
		return "Sv�veindramning";
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
