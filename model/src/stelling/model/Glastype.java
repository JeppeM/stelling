package stelling.model;

/**
 * Repr¾senterer forskellige typer af glas til brug ved indramningsopgaver
 */
public class Glastype extends Materialetype {

	public static final Glastype NIL = new Glastype("Intet valgt");

	public Glastype(String navn) {
		super(navn);
	}
}
