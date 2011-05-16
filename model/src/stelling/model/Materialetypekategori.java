package stelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Repræsenterer en generel kategori af materialetyper, f.eks. 'glastype' eller
 * 'rammetype'
 * <p>
 * Denne klasse træder i stedet for dedikerede klasser til specifikke
 * materialetyper, idet nye kategorier af materialetyper så kan tilføjes
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
	 *            Navn på den nye materialekategori
	 */
	public Materialetypekategori(String kategorinavn) {
		navn = kategorinavn;
		materialetyper = new ArrayList<Materialetype>();
		nil = new Materialetype("Ingen") {
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
