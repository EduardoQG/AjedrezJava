package es.studium.practicaAjedrez;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class VistaNuevaPartida extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Label lblJug1 = new Label("Jugador 1");
	Label lblJug2 = new Label("Jugador 2");
	TextField txtJug1 = new TextField(10);
	TextField txtJug2 = new TextField(10);
	Button btnComenzar = new Button("Comenzar Partida");
	Button btnVolver = new Button("Volver");

	VistaNuevaPartida() {
		setSize(300, 200);
		setLayout(null);
		add(lblJug1);
		lblJug1.setBounds(50, 50, 55, 20);
		add(lblJug2);
		lblJug2.setBounds(50, 80, 55, 20);
		add(txtJug1);
		txtJug1.setBounds(110, 50, 100, 20);
		add(txtJug2);
		txtJug2.setBounds(110, 80, 100, 20);
		add(btnComenzar);
		btnComenzar.setBounds(110, 120, 100, 20);
		add(btnVolver);
		btnVolver.setBounds(135, 150, 50, 20);

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
