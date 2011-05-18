package stelling.model;

/**
 * Repr�senterer en materialetype, hvis pris er uafh�ngig af opgavens
 * st�rrelsesm�ssige omfang
 */
public class FastPrisMaterialeType extends MaterialeType {
	FastPrisMaterialeType(String typeNavn) {
		super(typeNavn);
	}

	@Override
	public Beloeb beregnPris(LaengdeMaal hoejde, LaengdeMaal bredde, Beloeb pris) {
		return pris;
	}
}
