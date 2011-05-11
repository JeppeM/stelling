package stelling.model;

/**
 * Repr¾senterer en tilpasset indramning
 */
public class TilpassetIndramning extends Indramning {
	private TilpassetRammetype rammetype;
	private Glastype glastype;
	private Bagpaptype bagpaptype;
	private Baggrundstype baggrundstype;

	/**
	 * Kreerer en ny tilpasset indramning med relevante defaults
	 */
	public TilpassetIndramning() {
		rammetype = TilpassetRammetype.NIL;
		glastype = Glastype.NIL;
		bagpaptype = Bagpaptype.NIL;
		baggrundstype = Baggrundstype.NIL;
	}

	/**
	 * Returnerer opgavens rammetype
	 * 
	 * @return Rammetype valgt i denne opgave
	 */
	public TilpassetRammetype getRammetype() {
		return rammetype;
	}

	/**
	 * ®ndrer opgavens rammetype
	 * 
	 * @param rammetype
	 *            Den nye rammetype valgt for denne opgave
	 */
	public void setRammetype(TilpassetRammetype rammetype) {
		this.rammetype = rammetype;
	}

	/**
	 * Returnerer opgavens glastype
	 * 
	 * @return Glastype valgt i denne opgave
	 */
	public Glastype getGlastype() {
		return glastype;
	}

	/**
	 * ®ndrer opgavens glastype
	 * 
	 * @param rammetype
	 *            Den nye glastype valgt for denne opgave
	 */
	public void setGlastype(Glastype glastype) {
		this.glastype = glastype;
	}

	/**
	 * Returnerer opgavens bagpaptype
	 * 
	 * @return Bagpaptype valgt i denne opgave
	 */
	public Bagpaptype getBagpaptype() {
		return bagpaptype;
	}

	/**
	 * ®ndrer opgavens bagpaptype
	 * 
	 * @param rammetype
	 *            Den nye bagpaptype valgt for denne opgave
	 */
	public void setBagpaptype(Bagpaptype bagpaptype) {
		this.bagpaptype = bagpaptype;
	}

	/**
	 * Returnerer opgavens Baggrundstype
	 * 
	 * @return Baggrundstype valgt i denne opgave
	 */
	public Baggrundstype getBaggrundstype() {
		return baggrundstype;
	}

	/**
	 * ®ndrer opgavens baggrundstype
	 * 
	 * @param rammetype
	 *            Den nye baggrundstype valgt for denne opgave
	 */
	public void setBaggrundstype(Baggrundstype baggrundstype) {
		this.baggrundstype = baggrundstype;
	}

	@Override
	protected String beskrivOpgaveType() {
		return "Tilpasset indramning";
	}

	@Override
	protected String beskrivDetaljer(String linjePrefix) {
		StringBuilder builder = new StringBuilder();
		builder.append(linjePrefix).append("Rammetype: ")
				.append(rammetype.navn()).append("\n");
		builder.append(linjePrefix).append("Glastype: ")
				.append(glastype.navn()).append("\n");
		builder.append(linjePrefix).append("Bagpaptype: ")
				.append(bagpaptype.navn()).append("\n");
		builder.append(linjePrefix).append("Baggrundstype: ")
				.append(baggrundstype.navn()).append("\n");
		return builder.toString();
	}

	@Override
	public Beloeb samletPris() {
		return Beloeb.NUL;
	}
}
