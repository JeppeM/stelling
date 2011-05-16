package stelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

	/**
	 * Sorterer de specificerede materialetyper efter navn
	 * 
	 * @param materialeTyper
	 *            Materialetyper der skal sorteres
	 * @return Materialetyper sorteret efter navn
	 */
	public static final List<MaterialeType> sorterMaterialeTyper(
			Collection<MaterialeType> materialeTyper) {
		List<MaterialeType> typer = new ArrayList<MaterialeType>(materialeTyper);
		Collections.sort(typer, new Comparator<MaterialeType>() {
			@Override
			public int compare(MaterialeType o1, MaterialeType o2) {
				return o1.navn().compareTo(o2.navn());
			}
		});
		return typer;
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
