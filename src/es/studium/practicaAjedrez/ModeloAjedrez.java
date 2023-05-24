package es.studium.practicaAjedrez;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		sentencia = "select nombreGanador, numMovimientosGanador from partidasajedrez.partida";
		
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
		
}
