package stelling.model;

/**
 * Repr¾senterer en materialetype, hvis pris udregnes iht. opgavens
 * omkredsm¾ssige omfang
 */
public class OmkredsPrisMaterialeType extends MaterialeType {
	OmkredsPrisMaterialeType(String typeNavn) {
		super(typeNavn);
	}

	@Override
	public Beloeb beregnPris(LaengdeMaal hoejde, LaengdeMaal bredde, Beloeb pris) {
		// meterFaktor konverterer fra millimeter til meter
		double meterFaktor = 1.0 / 1e3;
		double omkreds = 2 * hoejde.vaerdi() + bredde.vaerdi();
		return pris.multiplicer(meterFaktor * omkreds);
	}
}
