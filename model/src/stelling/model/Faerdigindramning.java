package stelling.model;

/**
 * Repr¾senterer en f¾rdigindramningsopgave
 */
public class Faerdigindramning extends Indramning {

	@Override
	public String beskrivOpgaveType() {
		return "F¾rdigindramning";
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
