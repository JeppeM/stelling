package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.OpgaveView;

import model.Forespoergsel;
import model.Opgave;
import model.Session;

/**
 * Controller der administrerer haendelser mellem en Session og MainViewet.
 */
public class MainController implements ActionListener {
	private Session session;
	private MainView mainView;
	
	/**
	 * kreerer en ikke-initialiseret SessionController.
	 * @param session
	 */
	public MainController() {
		this.session = null;
		this.mainView = null;
	}
	
	/**
	 * initialiserer controlleren ved at tilfoeje en reference til Session-objektet og MainViewet.
	 * @param session
	 * @param mainView
	 */
	public void init(Session session, MainView view) {
		this.session = session;
		this.mainView = view;
	}

	/**
	 * kaldt når brugeren interagerer med main viewet. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//ved tryk på "ny forespoergsel"
		nyForespoergsel();
	}

	/**
	 * Opretter et nyt Forespoergsel-objekt, et nyt ForespoergselView og en ny ForespoergselController.
	 * ForespoergselControlleren initialiseres med en reference til både ForespoergselViewet og Forespoergslen,
	 * mens ForespoergselViewet initialiseres med controlleren som action listener samt en reference til
	 * Forespoergslen.
	 */
	private void nyForespoergsel() {
		Forespoergsel forespoergsel = session.nyForespoergsel();
		ForespoergselView view = mainView.nyForespoergsel();
		ForespoergselController controller = new ForespoergselController();
		view.init(forespoergsel, controller);
		controller.init(forespoergsel, view);
	}

}
