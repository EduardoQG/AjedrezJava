package es.studium.practicaAjedrez;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class VistaMenuPrincipal extends Frame {
	
	private static final long serialVersionUID = 1L;
	Image jugar, help, rank, salir, menu, chessfight;
	Toolkit herramienta;

	VistaMenuPrincipal() {
		
		setSize(1200, 675);
		setResizable(false);
		setLocationRelativeTo(null);
		herramienta = getToolkit();
		chessfight = herramienta.getImage("imagenes\\chessfight.jpeg");
		jugar = herramienta.getImage("imagenes\\jugar.png");
		help = herramienta.getImage("imagenes\\ayuda.png");
		rank = herramienta.getImage("imagenes\\ranking.png");
		salir = herramienta.getImage("imagenes\\salir.png");
		menu = herramienta.getImage("imagenes\\menu.png");
		setVisible(true);
	}

	public void paint(Graphics g) {
		// Dibujar la imagen
		g.drawImage(chessfight, 0, 0, this);
		g.drawImage(menu, 400, 75, this);
		g.drawImage(jugar, 479, 180, this);
		g.drawImage(help, 479, 260, this);
		g.drawImage(rank, 479, 420, this);
		g.drawImage(salir, 479, 500, this);

	}
}