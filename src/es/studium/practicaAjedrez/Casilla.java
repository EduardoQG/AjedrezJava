package es.studium.practicaAjedrez;

public class Casilla {

	final int x;
	final int y;
	private boolean ocupada;
	private Ficha ficha;
	
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

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	
	
}
