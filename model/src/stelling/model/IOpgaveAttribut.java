package stelling.model;

/**
 * Repræsenterer en konkret attribut ved en specifik opgave, f.eks. at en given
 * indramning skal foretages med museumsglas
 */
public interface IOpgaveAttribut {

	/**
	 * Returnerer prisen for den pågældende attribut iht. den specificerede
	 * størrelse. Implementerende klasser må frit definere sammenhængen mellem
	 * størrelse og pris (f.eks. omkreds eller areal)
	 * 
	 * @param hoejde
	 *            Højden på opgaven
	 * @param bredde
	 *            Bredden på opgaven
	 * @return Pris for denne materialetype givet de specificerede mål
	 */
	public Beloeb pris(LaengdeMaal hoejde, LaengdeMaal bredde);

	/**
	 * Returnerer typen af denne attribut
	 * 
	 * @return Typen af denne attribut
	 */
	public IOpgaveAttributType attributType();

	/**
	 * Returnerer navnet på denne attribut
	 * 
	 * @return Navnet på denne attribut
	 */
	public String navn();
}
