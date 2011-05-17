package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.OpgaveView;

import model.Opgave;

/**
 * Controller der administrerer h¾ndelser mellem et OpgaveView og en Opgave.
 */
public class OpgaveController implements ActionListener {
	private Opgave opgave;
	private OpgaveView opgaveView;

	/**
	 * Controller for en opgave, der modtager events fra et OpgaveView
	 */
	public OpgaveController() {
		this.opgave = null;
		this.opgaveView = null;
	}
	
	public OpgaveController(Opgave opgave, OpgaveView view) {
		init(opgave, view);
	}

	/**
	 * initialiser controlleren ved at tilf¿je en reference til en opgave
	 * @param opgave
	 */
	public void init(Opgave opgave, OpgaveView opgaveView) {
		this.opgave = opgave;
		this.opgaveView = opgaveView;
	}

	/**
	 * kaldt af OpgaveViewet
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//implementation mangler
	}
}
