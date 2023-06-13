package es.studium.practicaAjedrez;

import java.awt.image.BufferedImage;

public class Ficha {

	private String tipoFicha;
	private BufferedImage imagenFicha;
	private Casilla casillaActual;
	private boolean esBlanca;
	private boolean viva;
	
	public Ficha (BufferedImage imagenFicha, String tipoFicha, boolean esBlanca) {
		this.imagenFicha = imagenFicha;
		this.tipoFicha = tipoFicha;
		this.esBlanca = esBlanca;
		viva = true;
	}
	

	public Casilla getCasillaActual() {
		return casillaActual;
	}

	public void setImagenFicha(BufferedImage imagenFicha) {
		this.imagenFicha = imagenFicha;
	}

	public void setCasillaActual(Casilla casillaActual) {
		
		if (this.casillaActual != null) {
			this.casillaActual.setFicha(null);
		}
		
		this.casillaActual = casillaActual;
		this.casillaActual.setFicha(this);
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

	public boolean getViva() {
		return viva;
	}

	public void setViva(boolean viva) {
		this.viva = viva;
	}
	
	public void morir () {
		imagenFicha = null;
		this.setViva(false);
	}

	
	
	
	
	
}
