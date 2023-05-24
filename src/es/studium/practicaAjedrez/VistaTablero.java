package es.studium.practicaAjedrez;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaTablero extends JPanel {

    private static final long serialVersionUID = 1L;
	
    JLabel jugador1 = new JLabel("Jugador 1");
    
    public VistaTablero() {
        JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().add(this);
        frame.setBackground(Color.LIGHT_GRAY);
        //frame.add(jugador1);
        
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
        
        BufferedImage imagenPeonBlanco;
        /*BufferedImage imagenPeonBlanco, imagenTorreBlanca, imagenCaballoBlanco, imagenAlfilBlanco, imagenReinaBlanca, imagenReyBlanco,
        imagenPeonNegro, imagen*/
        
        try {
            File archivoImgPeonBlanco = new File("imagenes/peonBlanco.png");
            imagenPeonBlanco = ImageIO.read(archivoImgPeonBlanco);
            g.drawImage(imagenPeonBlanco, 105, 150, this);
        } catch (IOException e) {
            System.out.println("Error al leer la imagen: " + e);
        }
        
   
       
    }
    
    public static void main (String[] args) {
    	
    	new VistaTablero();
    }
}

