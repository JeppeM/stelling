package stelling.model;

/**
 * Reprūsenterer en materialetype, hvis pris udregnes iht. opgavens arealmūssige
 * omfang
 */
public class ArealPrisMaterialeType extends MaterialeType {
	ArealPrisMaterialeType(String typeNavn) {
		super(typeNavn);
	}

	@Override
	public Beloeb beregnPris(LaengdeMaal hoejde, LaengdeMaal bredde, Beloeb pris) {
		// kvmFaktor konverterer fra kvadratmillimeter til kvadratmeter
		double kvmFaktor = 1.0 / 1e6;
		return pris.multiplicer(kvmFaktor * hoejde.vaerdi() * bredde.vaerdi());
	}
}
