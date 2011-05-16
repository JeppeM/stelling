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
public class MaterialeType {
	private final String navn;
	private final List<Materiale> materialetyper;
	private final Materiale nil;

	/**
	 * Kreerer en MaterialeType med det specificerede navn
	 * 
	 * @param typeNavn
	 *            Navn på den nye materialetype
	 */
	public MaterialeType(String typeNavn) {
		navn = typeNavn;
		materialetyper = new ArrayList<Materiale>();
		nil = new Materiale("Ingen") {
			@Override
			public Beloeb pris(LaengdeMaal højde, LaengdeMaal bredde) {
				return Beloeb.NUL;
			}
		};
		materialetyper.add(nil);
	}

	/**
	 * Returnerer navnet på denne materialetypekategori
	 * 
	 * @return Navnet på denne materialetypekategori
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer de tilgængelige materialetyper i denne kategori
	 * 
	 * @return Tilgængelige materialetyper
	 */
	public List<Materiale> materialetyper() {
		return Collections.unmodifiableList(materialetyper);
	}

	/**
	 * Sorterer de specificerede materialetyper efter navn
	 * 
	 * @param materialeTyper
	 *            Kategorier der skal sorteres
	 * @return Kategorier sorteret efter navn
	 */
	public static final List<MaterialeType> sorterKategorier(
			Collection<MaterialeType> materialeTyper) {
		List<MaterialeType> kategoriliste = new ArrayList<MaterialeType>(
				materialeTyper);
		Collections.sort(kategoriliste, new Comparator<MaterialeType>() {
			@Override
			public int compare(MaterialeType o1, MaterialeType o2) {
				return o1.navn().compareTo(o2.navn());
			}
		});
		return kategoriliste;
	}
}
