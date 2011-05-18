package stelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpgaveType {
	private final String navn;
	private final List<IOpgaveAttributType> attributTyper;

	public static final OpgaveType BLANK = new OpgaveType("<BLANK>",
			new ArrayList<IOpgaveAttributType>());

	public OpgaveType(String inNavn, List<IOpgaveAttributType> inAttributTyper) {
		navn = inNavn;
		attributTyper = new ArrayList<IOpgaveAttributType>(inAttributTyper);
	}

	public Opgave nyOpgave() {
		return new Opgave(this);
	}

	public String navn() {
		return navn;
	}

	/**
	 * Sorterer de specificerede opgavetyper efter navn
	 * 
	 * @param opgaveTyper
	 *            Opgavetyper der skal sorteres
	 * @return Opgavetyper sorteret efter navn
	 */
	public static List<OpgaveType> sorterOpgaveTyper(
			Collection<OpgaveType> opgaveTyper) {
		List<OpgaveType> typer = new ArrayList<OpgaveType>(opgaveTyper);
		Collections.sort(typer, new Comparator<OpgaveType>() {
			@Override
			public int compare(OpgaveType o1, OpgaveType o2) {
				return o1.navn().compareTo(o2.navn());
			}
		});
		return typer;
	}

	/**
	 * Returnerer et map med denne opgavetypes attributtyper og deres respektive
	 * defaultv¾rdier
	 * 
	 * @return Map over attributtypernes defaultv¾rdier
	 */
	public Map<IOpgaveAttributType, IOpgaveAttribut> defaultAttributter() {
		Map<IOpgaveAttributType, IOpgaveAttribut> map = new HashMap<IOpgaveAttributType, IOpgaveAttribut>();
		for (IOpgaveAttributType attributType : attributTyper) {
			map.put(attributType, attributType.defaultVaerdi());
		}
		return map;
	}
}
