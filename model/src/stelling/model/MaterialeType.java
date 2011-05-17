package stelling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repræsenterer en generel materialetype, f.eks. 'glastype' eller 'rammetype'
 * <p>
 * Denne klasse træder i stedet for dedikerede klasser til specifikke
 * materialetyper, idet nye kategorier af materialetyper så kan tilføjes
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
	 *            Navn på den nye materialetype
	 */
	MaterialeType(String typeNavn) {
		navn = typeNavn;
		materialer = new ArrayList<Materiale>();
		nil = new Materiale(this, "Ingen", Beloeb.NUL);
		defaultVaerdi = nil;
		materialer.add(nil);
	}

	/**
	 * Returnerer navnet på denne materialetype
	 * 
	 * @return Navnet på denne materialetype
	 */
	@Override
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer de tilgængelige materialer af denne type
	 * 
	 * @return Tilgængelige materialer
	 */
	public List<Materiale> materialer() {
		return Collections.unmodifiableList(materialer);
	}

	@Override
	public IOpgaveAttribut defaultVaerdi() {
		return defaultVaerdi;
	}

	/**
	 * Ændrer denne materialetypes defaultværdi
	 * 
	 * @param defaultVaerdi
	 *            Ny defaultværdi
	 */
	public void setDefaultVaerdi(Materiale inDefaultVaerdi) {
		if (inDefaultVaerdi.attributType() != this) {
			throw new IllegalArgumentException(
					"Den specificerede default værdi var af en forkert type.");
		}
		this.defaultVaerdi = defaultVaerdi;
	}

	/**
	 * Beregner en pris ud fra de angivne oplysninger
	 * 
	 * @param hoejde
	 *            Opgavens højde
	 * @param bredde
	 *            Opgavens bredde
	 * @param pris
	 *            Materialets pris
	 * @return Pris for det angivne materiale i den angivne størrelse
	 */
	public abstract Beloeb beregnPris(LaengdeMaal hoejde, LaengdeMaal bredde,
			Beloeb pris);
}
