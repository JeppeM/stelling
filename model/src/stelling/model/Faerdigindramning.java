package stelling.model;

/**
 * Repr�senterer en f�rdigindramningsopgave
 */
public class Faerdigindramning extends Indramning {

	@Override
	public String beskrivOpgaveType() {
		return "F�rdigindramning";
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
