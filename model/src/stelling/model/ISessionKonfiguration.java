package stelling.model;

import java.util.Collection;

/**
 * Repr�senterer et konfigurationsobjekt til initialisering af en session
 * 
 */
public interface ISessionKonfiguration {

	/**
	 * Returnerer en m�ngde opgavetyper
	 * 
	 * @return Opgavetyper som sessionen skal underst�tte
	 */
	Collection<OpgaveType> opgaveTyper();

	/**
	 * Returnerer opgavetypen som skal bruges som default ved kreering af nye
	 * foresp�rgsler
	 * 
	 * @return Default opgavetype
	 */
	OpgaveType defaultOpgaveType();

}
