package stelling.model;

/**
 * Repr¾senterer forskellige typer af tilpasselige rammer til brug ved
 * indramningsopgaver
 */
public class TilpassetRammetype extends Materialetype {

	public static final TilpassetRammetype NIL = new TilpassetRammetype(
			"Ingen valgt");

	public TilpassetRammetype(String navn) {
		super(navn);
	}
}
