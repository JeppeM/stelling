package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repr�senterer en generel materialetype, f.eks. 'glastype' eller 'rammetype'
 * <p>
 * Denne klasse tr�der i stedet for dedikerede klasser til specifikke
 * materialetyper, idet nye kategorier af materialetyper s� kan tilf�jes
 * dynamisk
 */
abstract class MaterialeType implements IOpgaveAttributType {
	private final String navn;
	private final List<Materiale> materialer;
	private final Materiale nil;
	private Materiale defaultVaerdi;

	/**
	 * Kreerer en MaterialeType med det specificerede navn
	 * 
	 * @param typeNavn
	 *            Navn p� den nye materialetype
	 */
	MaterialeType(String typeNavn) {
		navn = typeNavn;
		materialer = new ArrayList<Materiale>();
		nil = new Materiale(this, "Ingen", Beloeb.NUL);
		defaultVaerdi = nil;
		materialer.add(nil);
	}

	/**
	 * Returnerer navnet p� denne materialetype
	 * 
	 * @return Navnet p� denne materialetype
	 */
	@Override
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer de tilg�ngelige materialer af denne type
	 * 
	 * @return Tilg�ngelige materialer
	 */
	public List<Materiale> materialer() {
		return Collections.unmodifiableList(materialer);
	}

	@Override
	public IOpgaveAttribut defaultVaerdi() {
		return defaultVaerdi;
	}

	/**
	 * �ndrer denne materialetypes defaultv�rdi
	 * 
	 * @param defaultVaerdi
	 *            Ny defaultv�rdi
	 */
	public void setDefaultVaerdi(Materiale inDefaultVaerdi) {
		if (inDefaultVaerdi.attributType() != this) {
			throw new IllegalArgumentException(
					"Den specificerede default v�rdi var af en forkert type.");
		}
		this.defaultVaerdi = defaultVaerdi;
	}

	/**
	 * Beregner en pris ud fra de angivne oplysninger
	 * 
	 * @param hoejde
	 *            Opgavens h�jde
	 * @param bredde
	 *            Opgavens bredde
	 * @param pris
	 *            Materialets pris
	 * @return Pris for det angivne materiale i den angivne st�rrelse
	 */
	public abstract Beloeb beregnPris(LaengdeMaal hoejde, LaengdeMaal bredde,
			Beloeb pris);
}
