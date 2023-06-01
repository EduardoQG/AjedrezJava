package es.studium.practicaAjedrez;

import java.awt.image.BufferedImage;

public class Ficha {

	private String tipoFicha;
	private BufferedImage imagenFicha;
	private Casilla casillaActual;
	private boolean esBlanca;
	
	public Ficha (BufferedImage imagenFicha, String tipoFicha, boolean esBlanca) {
		this.imagenFicha = imagenFicha;
		this.tipoFicha = tipoFicha;
		this.esBlanca = esBlanca;
	}

	public Casilla getCasillaActual() {
		return casillaActual;
	}

	
	public void setCasillaActual(Casilla casillaActual) {
		// La antigua casilla pasa a estar vacía.
		this.casillaActual.setOcupada(false);
		// Se establece la nueva casilla.
		this.casillaActual = casillaActual;
		// La nueva casilla pasa a estar ocupada.
		casillaActual.setOcupada(true);
	}

	public BufferedImage getImagenFicha() {
		return imagenFicha;
	}
	
	public String getTipoFicha () {
		return tipoFicha;
	}
	
	public boolean getEsBlanca () {
		return esBlanca;
	}
	
	
	
	
}
