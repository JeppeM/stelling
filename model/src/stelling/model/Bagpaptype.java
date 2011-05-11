package stelling.model;

/**
 * Repr¾senterer forskellige typer af bagpap til brug ved indramningsopgaver
 */
public class Bagpaptype extends Materialetype {

	public static final Bagpaptype NIL = new Bagpaptype("Intet valgt");

	Bagpaptype(String navn) {
		super(navn);
	}
}
