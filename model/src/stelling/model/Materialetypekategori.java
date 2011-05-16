package stelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Repr�senterer en generel kategori af materialetyper, f.eks. 'glastype' eller
 * 'rammetype'
 * <p>
 * Denne klasse tr�der i stedet for dedikerede klasser til specifikke
 * materialetyper, idet nye kategorier af materialetyper s� kan tilf�jes
 * dynamisk
 */
public class Materialetypekategori {
	private final String navn;
	private final List<Materialetype> materialetyper;
	private final Materialetype nil;

	/**
	 * Kreerer en Materialetypekategori med det specificerede navn
	 * 
	 * @param kategorinavn
	 *            Navn p� den nye materialekategori
	 */
	public Materialetypekategori(String kategorinavn) {
		navn = kategorinavn;
		materialetyper = new ArrayList<Materialetype>();
		nil = new Materialetype("Ingen") {
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
	public List<Materialetype> materialetyper() {
		return Collections.unmodifiableList(materialetyper);
	}

	/**
	 * Sorterer de specificerede kategorier efter navn
	 * 
	 * @param kategorier
	 *            Kategorier der skal sorteres
	 * @return Kategorier sorteret efter navn
	 */
	public static final List<Materialetypekategori> sorterKategorier(
			Collection<Materialetypekategori> kategorier) {
		List<Materialetypekategori> kategoriliste = new ArrayList<Materialetypekategori>(
				kategorier);
		Collections.sort(kategoriliste,
				new Comparator<Materialetypekategori>() {
					@Override
					public int compare(Materialetypekategori o1,
							Materialetypekategori o2) {
						return o1.navn().compareTo(o2.navn());
					}
				});
		return kategoriliste;
	}
}
