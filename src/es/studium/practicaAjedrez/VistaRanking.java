package es.studium.practicaAjedrez;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

/*
 * ChoRanking se iba a utilizar para cambiar entre ranking de movimientos o de tiempo. 
 * Finalmente no vamos a usar el ranking de tiempo (en principio).
 */


public class VistaRanking {

	Frame frame = new Frame ("Ranking");
	Label lblSuperior = new Label ("Ordenar por:");
	// Choice choRanking = new Choice();
	Label lblInferior = new Label(" ------- Ranking -------");
	TextArea txtRanking = new TextArea(6, 30);
	Button btnVolver = new Button("Volver");
	
	ModeloAjedrez mv = new ModeloAjedrez(); // Temporal para pruebas.
	
	public VistaRanking () {
		
		frame.setSize(310, 265);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		frame.add(lblSuperior);
		//frame.add(choRanking);
		//choRanking.add("Tiempo"); choRanking.add("Movimientos");
		
		frame.add(lblInferior);
		frame.add(txtRanking);
		frame.add(btnVolver);
		txtRanking.append("Posición      Jugador     Movimientos\n");
		mv.rellenarRanking(txtRanking);
		
		frame.setVisible(true);
	}
		
	public static void main (String [] args) {
		
		new VistaRanking();
	}
}
