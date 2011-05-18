package stelling.model;

/**
 * Repr¾senterer en materialetype, hvis pris er uafh¾ngig af opgavens
 * st¿rrelsesm¾ssige omfang
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
