package es.studium.practicaAjedrez;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaTablero extends JPanel {

    private static final long serialVersionUID = 1L;
	
    BufferedImage peonBlanco1, peonBlanco2, peonBlanco3, peonBlanco4, peonBlanco5, peonBlanco6, peonBlanco7, peonBlanco8, 
    torreBlanca1, torreBlanca2, caballoBlanco1, caballoBlanco2, alfilBlanco1, alfilBlanco2, reinaBlanca, reyBlanco;
    
    Casilla [] casillas;
    
    public VistaTablero() {
        JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().add(this);
        frame.setBackground(Color.LIGHT_GRAY);
        
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
		
        
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        /*
            FUNCIONAMIENTO CONSTRUCCIÓN TABLERO:
            Primero se crea un cuadrado negro de 400x400 que comienza en la posición 100,100.
            El primer bucle va quitando cuadrados negros de 50x50 en las filas impares.
            El segundo bucle hace lo mismo pero en las filas pares.
        */
    	g.setColor(new Color(160, 82, 45));
    	
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
        g.setColor(Color.black);
        g.drawString("Nombre jugador 1", 600, 100);
        g.drawString("Nombre jugador 2", 600, 500);
        
        
        
        try {
            File archivoImgPeonBlanco = new File("imagenes/peonBlanco.png");
            peonBlanco1 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco1, 105, 150, this);
            peonBlanco2 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco2, 155, 150, this);
            peonBlanco3 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco3, 205, 150, this);
            peonBlanco4 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco4, 255, 150, this);
            peonBlanco5 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco5, 305, 150, this);
            peonBlanco6 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco6, 355, 150, this);
            peonBlanco7 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco7, 405, 150, this);
            peonBlanco8 = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(peonBlanco8, 455, 150, this);
            
            File archivoImgTorreBlanca = new File("imagenes/torreBlanca.png");
            torreBlanca1 = ImageIO.read(archivoImgTorreBlanca);
            g.drawImage(torreBlanca1, 105, 100, this);
            torreBlanca2 = ImageIO.read(archivoImgTorreBlanca);
            g.drawImage(torreBlanca2, 455, 100, this);
          
            File archivoImgCaballoBlanco = new File("imagenes/caballoBlanco.png");
            caballoBlanco1 = ImageIO.read(archivoImgCaballoBlanco);
            g.drawImage(caballoBlanco1, 155, 100, this);
            caballoBlanco2 = ImageIO.read(archivoImgCaballoBlanco);
            g.drawImage(caballoBlanco2, 405, 100, this);
            
            File archivoImgAlfilBlanco = new File("imagenes/alfilBlanco.png");
            alfilBlanco1 = ImageIO.read(archivoImgAlfilBlanco);
            g.drawImage(alfilBlanco1, 205, 100, this);
            alfilBlanco2 = ImageIO.read(archivoImgAlfilBlanco);
            g.drawImage(alfilBlanco2, 355, 100, this);
            
            File archivoImgReyBlanco = new File("imagenes/reyBlanco.png");
            reyBlanco = ImageIO.read(archivoImgReyBlanco);
            g.drawImage(reyBlanco, 255, 100, this);
            
            File archivoImgReinaBlanca = new File("imagenes/reinaBlanca.png");
            reinaBlanca = ImageIO.read(archivoImgReinaBlanca);
            g.drawImage(reinaBlanca, 305, 100, this);
            
        } catch (IOException e) {
            System.out.println("Error al leer la imagen: " + e);
        }
        
   
       
    }
    
    public static void main (String[] args) {
    	
    	new VistaTablero();
    }
}

