package es.studium.practicaAjedrez;

public class Pruebas {

    public static void main(String[] args) {
       
    	VistaTablero tablero = new VistaTablero();
    	
    	for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				System.out.println("Soy la casilla " + i + j + ""
						+ " y mis coordenadas son " + tablero.casillas[i][j].x + " " + tablero.casillas[i][j].y);
				}
			}
		}
}

	
	
	