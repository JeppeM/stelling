package stelling.model;

/**
 * Repr¾senterer forskellige typer af baggrund til brug ved indramningsopgaver
 */
public class Baggrundstype extends Materialetype {

	public static final Baggrundstype NIL = new Baggrundstype("Ingen valgt");

	public Baggrundstype(String navn) {
		super(navn);
	}
}
