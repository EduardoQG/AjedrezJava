package es.studium.practicaAjedrez;

public class Pruebas {

    public static void main(String[] args) {
       
    	VistaTablero t = new VistaTablero();
    	
    	System.out.println(t.peonBlanco1.getEsBlanca());
    	System.out.println(t.peonBlanco1.getCasillaActual().x + " " + t.peonBlanco1.getCasillaActual().y);
    	System.out.println(t.casillas[1][0].getOcupada());
    	System.out.println(t.casillas[3][3].getOcupada());
    	
    	t.moverFicha(t.peonBlanco1, t.casillas[3][3]);
    	
    	System.out.println(t.peonBlanco1.getCasillaActual().x + " " + t.peonBlanco1.getCasillaActual().y);
    	System.out.println(t.casillas[1][0].getOcupada());
    	System.out.println(t.casillas[3][3].getOcupada());
    }
}

	
	
	