package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ForespoergselView;
import view.OpgaveView;

import model.Forespoergsel;
import model.Opgave;

/**
 * Controller der administrerer h�ndelser mellem et ForespoergselView og en Forespoergsel.
 */
public class ForespoergselController implements ActionListener {
	private Forespoergsel forespoergsel;
	private ForespoergselView forespoergselView;
	
	/**
	 * konstrukt�r for en ForespeorgselController.
	 */
	public ForespoergselController() {
		this.forespoergsel = null;
		this.forespoergselView = null;
	}
	
	/**
	 * alternativ konstrukt�r som kreerer en ForespoergselController som initialiseres direkte
	 * @param forespoergsel
	 * @param View
	 */
	public ForespoergselController(Forespoergsel forespoergsel, ForespoergselView view) {
		init(forespoergsel, view);
	}
	
	/**
	 * initialiserer en forespoergselController ved at tilfoeje
	 * referencer til et ForespoergselView og en Forespoergsel
	 * @param forespoergsel
	 * @param forespoergselView
	 */
	public void init(Forespoergsel forespoergsel, ForespoergselView forespoergselView) {
		this.forespoergsel = forespoergsel;
		this.forespoergselView = forespoergselView;
	}

	/**
	 * Kaldt af ForespoergselViewet n�r brugeren interagerer med viewet.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//ved tryk p� "ny opgave"
		nyOpgave();
	}
	
	/**
	 * Opretter et nyt Opgave-objekt, et nyt OpgaveView og en ny OpgaveController.
	 * OpgaveControlleren initialiseres med en reference til b�de OpgaveViewet og Opgaven, mens
	 * OpgaveViewet initialiseres med en reference til Opgaven.
	 */
	private void nyOpgave() {
		Opgave opgave = forespoergsel.nyOpgave();
		OpgaveView view = forespoergselView.nyOpgave();
		OpgaveController controller = new OpgaveController();
		view.init(opgave, controller);
		controller.init(opgave, view);
	}

}
