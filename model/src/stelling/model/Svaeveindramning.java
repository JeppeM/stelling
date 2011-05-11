package stelling.model;

/**
 * Repr¾senterer en sv¾veindramningsopgave
 */
public class Svaeveindramning extends Indramning {

	@Override
	protected String beskrivOpgaveType() {
		return "Sv¾veindramning";
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
