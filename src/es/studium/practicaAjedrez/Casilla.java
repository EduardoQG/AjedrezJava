package es.studium.practicaAjedrez;

public class Casilla {

	final int x;
	final int y;
	private boolean ocupada;
	
	public Casilla (int x, int y) {
		this.x = x;
		this.y = y;
		ocupada = false;
	}
	
	public boolean getOcupada() {
		return ocupada;
	}
	
	public void setOcupada (boolean ocupada) {
		this.ocupada = ocupada;
	}
}
