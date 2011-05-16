package stelling.model;

/**
 * Repr�senterer en konkret attribut ved en specifik opgave, f.eks. at en given
 * indramning skal foretages med museumsglas
 */
public interface IOpgaveAttribut {

	/**
	 * Returnerer prisen for den p�g�ldende attribut iht. den specificerede
	 * st�rrelse. Implementerende klasser m� frit definere sammenh�ngen mellem
	 * st�rrelse og pris (f.eks. omkreds eller areal)
	 * 
	 * @param hoejde
	 *            H�jden p� opgaven
	 * @param bredde
	 *            Bredden p� opgaven
	 * @return Pris for denne materialetype givet de specificerede m�l
	 */
	public Beloeb pris(LaengdeMaal hoejde, LaengdeMaal bredde);

	/**
	 * Returnerer typen af denne attribut
	 * 
	 * @return Typen af denne attribut
	 */
	public IOpgaveAttributType attributType();

	/**
	 * Returnerer navnet p� denne attribut
	 * 
	 * @return Navnet p� denne attribut
	 */
	public String navn();
}
