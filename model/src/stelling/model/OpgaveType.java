package stelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OpgaveType {
	private final String navn;
	private final List<IOpgaveAttributType> attributTyper;

	public static final OpgaveType BLANK = new OpgaveType("<BLANK>");

	public OpgaveType(String inNavn) {
		navn = inNavn;
		attributTyper = new ArrayList<IOpgaveAttributType>();
	}

	public Opgave nyOpgave() {
		return new Opgave(this);
	}

	public String navn() {
		return navn;
	}

	public void tilfoejAttributType(IOpgaveAttributType attributType) {
		attributTyper.add(attributType);
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
}
