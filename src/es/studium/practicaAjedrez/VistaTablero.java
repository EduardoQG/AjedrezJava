package es.studium.practicaAjedrez;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaTablero extends JPanel {

	private static final long serialVersionUID = 1L;

	Ficha peonBlanco1, peonBlanco2, peonBlanco3, peonBlanco4, peonBlanco5, peonBlanco6, peonBlanco7, peonBlanco8,
			torreBlanca1, torreBlanca2, caballoBlanco1, caballoBlanco2, alfilBlanco1, alfilBlanco2, reinaBlanca,
			reyBlanco, peonNegro1, peonNegro2, peonNegro3, peonNegro4, peonNegro5, peonNegro6, peonNegro7, peonNegro8,
			torreNegra1, torreNegra2, caballoNegro1, caballoNegro2, alfilNegro1, alfilNegro2, reyNegro, reinaNegra;

	Casilla[][] casillas;
	JFrame frame;
	String turno;
	String jaque;
	Image fondo;
	Toolkit herramienta;

	public VistaTablero() {
		frame = new JFrame();
		frame.setSize(900, 700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		herramienta = getToolkit();
		fondo = herramienta.getImage("imagenes\\fondo.jpg");

		turno = "Blancas";
		jaque = "";

		casillas = new Casilla[8][8];

		int x = 100, y = 100;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				casillas[i][j] = new Casilla(x, y);
				if (x != 450) {
					x += 50;
				} else {
					x = 100;
				}
			}
			y += 50;
		}

		try {
			// FICHAS BLANCAS:

			// Se crea la ficha y se le añade la imagen.
			File archivoImgPeonBlanco = new File("imagenes/peonBlanco.png");
			peonBlanco1 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			// Se sitúa la ficha en la casilla inicial.
			peonBlanco1.setCasillaActual(casillas[1][0]);

			peonBlanco2 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco2.setCasillaActual(casillas[1][1]);
			peonBlanco3 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco3.setCasillaActual(casillas[1][2]);
			peonBlanco4 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco4.setCasillaActual(casillas[1][3]);
			peonBlanco5 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco5.setCasillaActual(casillas[1][4]);
			peonBlanco6 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco6.setCasillaActual(casillas[1][5]);
			peonBlanco7 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco7.setCasillaActual(casillas[1][6]);
			peonBlanco8 = new Ficha(ImageIO.read(archivoImgPeonBlanco), "peon", true);
			peonBlanco8.setCasillaActual(casillas[1][7]);
			File archivoImgTorreBlanca = new File("imagenes/torreBlanca.png");
			torreBlanca1 = new Ficha(ImageIO.read(archivoImgTorreBlanca), "torre", true);
			torreBlanca1.setCasillaActual(casillas[0][0]);
			torreBlanca2 = new Ficha(ImageIO.read(archivoImgTorreBlanca), "torre", true);
			torreBlanca2.setCasillaActual(casillas[0][7]);
			File archivoImgCaballoBlanco = new File("imagenes/caballoBlanco.png");
			caballoBlanco1 = new Ficha(ImageIO.read(archivoImgCaballoBlanco), "caballo", true);
			caballoBlanco1.setCasillaActual(casillas[0][1]);
			caballoBlanco2 = new Ficha(ImageIO.read(archivoImgCaballoBlanco), "caballo", true);
			caballoBlanco2.setCasillaActual(casillas[0][6]);
			File archivoImgAlfilBlanco = new File("imagenes/alfilBlanco.png");
			alfilBlanco1 = new Ficha(ImageIO.read(archivoImgAlfilBlanco), "alfil", true);
			alfilBlanco1.setCasillaActual(casillas[0][2]);
			alfilBlanco2 = new Ficha(ImageIO.read(archivoImgAlfilBlanco), "alfil", true);
			alfilBlanco2.setCasillaActual(casillas[0][5]);
			File archivoImgReyBlanco = new File("imagenes/reyBlanco.png");
			reyBlanco = new Ficha(ImageIO.read(archivoImgReyBlanco), "rey", true);
			reyBlanco.setCasillaActual(casillas[0][3]);
			File archivoImgReinaBlanca = new File("imagenes/reinaBlanca.png");
			reinaBlanca = new Ficha(ImageIO.read(archivoImgReinaBlanca), "reina", true);
			reinaBlanca.setCasillaActual(casillas[0][4]);

			// FICHAS NEGRAS:

			File archivoImgPeonNegro = new File("imagenes/peonNegro.png");
			peonNegro1 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro1.setCasillaActual(casillas[6][0]);
			peonNegro2 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro2.setCasillaActual(casillas[6][1]);
			peonNegro3 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro3.setCasillaActual(casillas[6][2]);
			peonNegro4 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro4.setCasillaActual(casillas[6][3]);
			peonNegro5 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro5.setCasillaActual(casillas[6][4]);
			peonNegro6 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro6.setCasillaActual(casillas[6][5]);
			peonNegro7 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro7.setCasillaActual(casillas[6][6]);
			peonNegro8 = new Ficha(ImageIO.read(archivoImgPeonNegro), "peon", false);
			peonNegro8.setCasillaActual(casillas[6][7]);
			File archivoImgTorreNegra = new File("imagenes/torreNegra.png");
			torreNegra1 = new Ficha(ImageIO.read(archivoImgTorreNegra), "torre", false);
			torreNegra1.setCasillaActual(casillas[7][0]);
			torreNegra2 = new Ficha(ImageIO.read(archivoImgTorreNegra), "torre", false);
			torreNegra2.setCasillaActual(casillas[7][7]);
			File archivoImgCaballoNegro = new File("imagenes/caballoNegro.png");
			caballoNegro1 = new Ficha(ImageIO.read(archivoImgCaballoNegro), "caballo", false);
			caballoNegro1.setCasillaActual(casillas[7][1]);
			caballoNegro2 = new Ficha(ImageIO.read(archivoImgCaballoNegro), "caballo", false);
			caballoNegro2.setCasillaActual(casillas[7][6]);
			File archivoImgAlfilNegro = new File("imagenes/alfilNegro.png");
			alfilNegro1 = new Ficha(ImageIO.read(archivoImgAlfilNegro), "alfil", false);
			alfilNegro1.setCasillaActual(casillas[7][2]);
			alfilNegro2 = new Ficha(ImageIO.read(archivoImgAlfilNegro), "alfil", false);
			alfilNegro2.setCasillaActual(casillas[7][5]);
			File archivoImgReyNegro = new File("imagenes/reyNegro.png");
			reyNegro = new Ficha(ImageIO.read(archivoImgReyNegro), "rey", false);
			reyNegro.setCasillaActual(casillas[7][4]);
			File archivoImgReinaNegra = new File("imagenes/reinaNegra.png");
			reinaNegra = new Ficha(ImageIO.read(archivoImgReinaNegra), "reina", false);
			reinaNegra.setCasillaActual(casillas[7][3]);

		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.getContentPane().add(this);
		frame.setBackground(Color.LIGHT_GRAY);

		// Crear las casillas:

		frame.setVisible(true);
	}

	public void paint(Graphics g) {

		/*
		 * FUNCIONAMIENTO CONSTRUCCIÓN TABLERO: Primero se crea un cuadrado negro de
		 * 400x400 que comienza en la posición 100,100. El primer bucle va quitando
		 * cuadrados negros de 50x50 en las filas impares. El segundo bucle hace lo
		 * mismo pero en las filas pares.
		 */
		g.drawImage(fondo, 0, -21, this);
		g.setColor(new Color(160, 82, 45));

		g.drawString("A", 120, 95);
		g.drawString("B", 170, 95);
		g.drawString("C", 220, 95);
		g.drawString("D", 270, 95);
		g.drawString("E", 320, 95);
		g.drawString("F", 370, 95);
		g.drawString("G", 420, 95);
		g.drawString("H", 470, 95);
		g.drawString("8", 90, 125);
		g.drawString("7", 90, 175);
		g.drawString("6", 90, 225);
		g.drawString("5", 90, 275);
		g.drawString("4", 90, 325);
		g.drawString("3", 90, 375);
		g.drawString("2", 90, 425);
		g.drawString("1", 90, 475);

		g.fillRect(100, 100, 400, 400);
		for (int i = 100; i <= 400; i += 100) {
			for (int j = 100; j <= 400; j += 100) {
				g.clearRect(i, j, 50, 50);
			}
		}
		for (int i = 150; i <= 450; i += 100) {
			for (int j = 150; j <= 450; j += 100) {
				g.clearRect(i, j, 50, 50);
			}
		}

		g.setColor(new Color(250, 247, 242));
		g.fillRect(600, 250, 200, 100);

		BufferedImage buffer = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = buffer.getGraphics();

		Font font = new Font("Serif", Font.BOLD, 24);
		g2.setFont(font);

		g2.setColor(Color.BLACK);
		g2.drawString("Turno " + turno, 0, 30);
		g.drawImage(buffer, 600, 250, null);

		BufferedImage buffer2 = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
		Graphics g3 = buffer2.getGraphics();

		Font font2 = new Font("Serif", Font.ITALIC, 22);
		g3.setFont(font2);

		g3.setColor(Color.BLACK);
		g3.drawString(jaque, 0, 30);
		g.drawImage(buffer2, 638, 300, null);

		// SITUAR FICHAS: se pinta la imagen en las coordenadas de su casilla actual.

		// FICHAS BLANCAS:

		g.drawImage(peonBlanco1.getImagenFicha(), (peonBlanco1.getCasillaActual().x + 5),
				peonBlanco1.getCasillaActual().y, this);

		g.drawImage(peonBlanco2.getImagenFicha(), (peonBlanco2.getCasillaActual().x + 5),
				peonBlanco2.getCasillaActual().y, this);

		g.drawImage(peonBlanco3.getImagenFicha(), (peonBlanco3.getCasillaActual().x + 5),
				peonBlanco3.getCasillaActual().y, this);

		g.drawImage(peonBlanco4.getImagenFicha(), (peonBlanco4.getCasillaActual().x + 5),
				peonBlanco4.getCasillaActual().y, this);

		g.drawImage(peonBlanco5.getImagenFicha(), (peonBlanco5.getCasillaActual().x + 5),
				peonBlanco5.getCasillaActual().y, this);

		g.drawImage(peonBlanco6.getImagenFicha(), (peonBlanco6.getCasillaActual().x + 5),
				peonBlanco6.getCasillaActual().y, this);

		g.drawImage(peonBlanco7.getImagenFicha(), (peonBlanco7.getCasillaActual().x + 5),
				peonBlanco7.getCasillaActual().y, this);

		g.drawImage(peonBlanco8.getImagenFicha(), (peonBlanco8.getCasillaActual().x + 5),
				peonBlanco8.getCasillaActual().y, this);

		g.drawImage(torreBlanca1.getImagenFicha(), (torreBlanca1.getCasillaActual().x + 5),
				torreBlanca1.getCasillaActual().y + 5, this);

		g.drawImage(torreBlanca2.getImagenFicha(), (torreBlanca2.getCasillaActual().x),
				torreBlanca2.getCasillaActual().y, this);

		g.drawImage(caballoBlanco1.getImagenFicha(), (caballoBlanco1.getCasillaActual().x),
				caballoBlanco1.getCasillaActual().y, this);

		g.drawImage(caballoBlanco2.getImagenFicha(), (caballoBlanco2.getCasillaActual().x),
				caballoBlanco2.getCasillaActual().y, this);

		g.drawImage(alfilBlanco1.getImagenFicha(), (alfilBlanco1.getCasillaActual().x),
				alfilBlanco1.getCasillaActual().y, this);

		g.drawImage(alfilBlanco2.getImagenFicha(), (alfilBlanco2.getCasillaActual().x),
				alfilBlanco2.getCasillaActual().y, this);

		g.drawImage(reyBlanco.getImagenFicha(), (reyBlanco.getCasillaActual().x), reyBlanco.getCasillaActual().y, this);

		g.drawImage(reinaBlanca.getImagenFicha(), (reinaBlanca.getCasillaActual().x), reinaBlanca.getCasillaActual().y,
				this);

		// FICHAS NEGRAS:

		g.drawImage(peonNegro1.getImagenFicha(), (peonNegro1.getCasillaActual().x + 5), peonNegro1.getCasillaActual().y,
				this);

		g.drawImage(peonNegro2.getImagenFicha(), (peonNegro2.getCasillaActual().x + 5), peonNegro2.getCasillaActual().y,
				this);

		g.drawImage(peonNegro3.getImagenFicha(), (peonNegro3.getCasillaActual().x + 5), peonNegro3.getCasillaActual().y,
				this);

		g.drawImage(peonNegro4.getImagenFicha(), (peonNegro4.getCasillaActual().x + 5), peonNegro4.getCasillaActual().y,
				this);

		g.drawImage(peonNegro5.getImagenFicha(), (peonNegro5.getCasillaActual().x + 5), peonNegro5.getCasillaActual().y,
				this);

		g.drawImage(peonNegro6.getImagenFicha(), (peonNegro6.getCasillaActual().x + 5), peonNegro6.getCasillaActual().y,
				this);

		g.drawImage(peonNegro7.getImagenFicha(), (peonNegro7.getCasillaActual().x + 5), peonNegro7.getCasillaActual().y,
				this);

		g.drawImage(peonNegro8.getImagenFicha(), (peonNegro8.getCasillaActual().x + 5), peonNegro8.getCasillaActual().y,
				this);

		g.drawImage(torreNegra1.getImagenFicha(), (torreNegra1.getCasillaActual().x), torreNegra1.getCasillaActual().y,
				this);

		g.drawImage(torreNegra2.getImagenFicha(), (torreNegra2.getCasillaActual().x), torreNegra2.getCasillaActual().y,
				this);

		g.drawImage(caballoNegro1.getImagenFicha(), (caballoNegro1.getCasillaActual().x),
				caballoNegro1.getCasillaActual().y, this);

		g.drawImage(caballoNegro2.getImagenFicha(), (caballoNegro2.getCasillaActual().x),
				caballoNegro2.getCasillaActual().y, this);

		g.drawImage(alfilNegro1.getImagenFicha(), (alfilNegro1.getCasillaActual().x), alfilNegro1.getCasillaActual().y,
				this);

		g.drawImage(alfilNegro2.getImagenFicha(), (alfilNegro2.getCasillaActual().x), alfilNegro2.getCasillaActual().y,
				this);

		g.drawImage(reyNegro.getImagenFicha(), (reyNegro.getCasillaActual().x), reyNegro.getCasillaActual().y, this);

		g.drawImage(reinaNegra.getImagenFicha(), (reinaNegra.getCasillaActual().x), reinaNegra.getCasillaActual().y,
				this);
	}

}