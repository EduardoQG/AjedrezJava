package es.studium.practicaAjedrez;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

public class VistaRanking extends Frame {

	private static final long serialVersionUID = 1L;
	
	Label lblInferior = new Label(" ------- Ranking -------");
	TextArea txtRanking = new TextArea(6, 30);
	Button btnVolver = new Button("Volver");
	
	public VistaRanking () {
		
		setSize(310, 265);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		add(lblInferior);
		add(txtRanking);
		add(btnVolver);
		txtRanking.append("Posición      Jugador     Movimientos\n");
		
		setVisible(true);
	}
	
}
