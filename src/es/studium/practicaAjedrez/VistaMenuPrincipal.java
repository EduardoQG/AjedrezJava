package es.studium.practicaAjedrez;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;

public class VistaMenuPrincipal {
	Frame ventana = new Frame("Menú Principal");
	Label lblMenu = new Label("MENÚ PRINCIPAL");
	Button btnPartida = new Button("Partida Nueva");
	Button btnRanking = new Button("Ranking");
	Button btnAyuda = new Button("Ayuda");
	Button btnSalir = new Button("Salir");

	VistaMenuPrincipal() {
		ventana.setSize(500, 300);
		ventana.setLayout(null);
		ventana.add(lblMenu);
		lblMenu.setBounds(200, 50, 100, 20);
		ventana.add(btnPartida);
		btnPartida.setBounds(200, 80, 100, 20);
		ventana.add(btnRanking);
		btnRanking.setBounds(200, 120, 100, 20);
		ventana.add(btnAyuda);
		btnAyuda.setBounds(200, 160, 100, 20);
		ventana.add(btnSalir);
		btnSalir.setBounds(225, 200, 50, 20);

		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
