package es.studium.practicaAjedrez;

public class Casilla {

	final int x;
	final int y;
	private Ficha ficha;
	
	public Casilla (int x, int y) {
		this.x = x;
		this.y = y;
		ficha = null;
	}
	

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	
	
}
