package es.studium.practicaAjedrez;

public class Pruebas {

	public static void main(String[] args) {
		
		Casilla[] casillas;

		// Crear las casillas:
		casillas = new Casilla[64];

		int x = 100, y = 100;
		for (int i = 0; i < 64; i++) {

			casillas [i] = new Casilla(x, y);
			
			if (x != 450) {
				x += 50;
			} else {
				x = 100;
				y += 50;
			}	
		}
		
		for (int i = 0; i < 64; i++) {
			
			System.out.println("Soy la casilla " + (i+1) + " y mis coordenadas son " + casillas[i].x + ", " + casillas[i].y + ".");
		}
	}

}
