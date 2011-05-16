package stelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Repr�senterer en generel materialetype, f.eks. 'glastype' eller 'rammetype'
 * <p>
 * Denne klasse tr�der i stedet for dedikerede klasser til specifikke
 * materialetyper, idet nye kategorier af materialetyper s� kan tilf�jes
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
	 *            Navn p� den nye materialetype
	 */
	public MaterialeType(String typeNavn) {
		navn = typeNavn;
		materialetyper = new ArrayList<Materiale>();
		nil = new Materiale("Ingen") {
			@Override
			public Beloeb pris(LaengdeMaal h�jde, LaengdeMaal bredde) {
				return Beloeb.NUL;
			}
		};
		materialetyper.add(nil);
	}

	/**
	 * Returnerer navnet p� denne materialetypekategori
	 * 
	 * @return Navnet p� denne materialetypekategori
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Returnerer de tilg�ngelige materialetyper i denne kategori
	 * 
	 * @return Tilg�ngelige materialetyper
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
