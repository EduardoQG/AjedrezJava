package es.studium.practicaAjedrez;

import java.awt.TextArea;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ModeloAjedrez {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/partidasajedrez";
	String login = "root";
	String password = "Studium2022;";
	String sentencia = "";

	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	VistaRanking vr; // Temporal para pruebas, quitarlo y llamarlo desde controlador.
	
	
	public ModeloAjedrez() {
		
		connection = this.conectar();
	}
	
	
	public Connection conectar() {
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			return connection;
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());
		} catch (SQLException sqle) {
			System.out.println("Error 2-" + sqle.getMessage());
		}
		return null;
	}
	
	public void rellenarRanking (TextArea txtRanking) {
		
		sentencia = "select nombreGanador, numMovimientosGanador from partidasajedrez.partida order by 2";
		
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultado = statement.executeQuery(sentencia);
			
			int ordenRanking = 0;
			
			while (resultado.next()) {
				ordenRanking++;
				txtRanking.append(ordenRanking + " ");
				txtRanking.append("                 " + resultado.getString("nombreGanador") + " ");
				txtRanking.append("                 " + resultado.getString("numMovimientosGanador") + "\n");	
			}
		} catch (SQLException sqle) {
			System.out.println("Error 5-" + sqle.getMessage());
		}
	}
	
	public void nuevoGanador (String nombre, int movimientos) {
		
		String sentencia = "insert into partida values (null, '" + nombre + "', " + movimientos + ");";
		
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.executeUpdate(sentencia);
		} catch (SQLException sqle) {
			System.out.println("Error 2-" + sqle.getMessage());
		}
	}


	public Casilla getCasillaSeleccionada(Controlador controlador, int xPulsada, int yPulsada) {
	
		Casilla casillaSeleccionada = null;
		// Buscar la casilla donde se encuentran las coordenadas.
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
	
				if (xPulsada > (controlador.tablero.casillas[i][j].x + 0) && xPulsada < (controlador.tablero.casillas[i][j].x + 50)
						&& yPulsada > (controlador.tablero.casillas[i][j].y + 0) && yPulsada < (controlador.tablero.casillas[i][j].y + 50)) {
	
					casillaSeleccionada = controlador.tablero.casillas[i][j];
				}
			}
		}
		return casillaSeleccionada;
	}


	public void reproducirSonido() {
	    try {
	        File archivoSonido = new File("sonidos\\mov.wav");
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
	        e.printStackTrace();
	    }

	}
}
