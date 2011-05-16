package stelling.model;

import java.util.ArrayList;
import java.util.List;

public class OpgaveType {
	private final String navn;
	private final List<IOpgaveAttributType> attributTyper;

	public OpgaveType(String inNavn) {
		navn = inNavn;
		attributTyper = new ArrayList<IOpgaveAttributType>();
	}

	public Opgave nyOpgave() {
		return new Opgave(this);
	}

	public Object navn() {
		return navn;
	}

	public void tilfoejAttributType(IOpgaveAttributType attributType) {
		attributTyper.add(attributType);
	}
}
