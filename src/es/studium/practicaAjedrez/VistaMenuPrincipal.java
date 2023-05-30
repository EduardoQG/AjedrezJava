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
		jugar = herramienta.getImage("imagenes\\jugar.jpg");
		help = herramienta.getImage("imagenes\\help.jpg");
		rank = herramienta.getImage("imagenes\\rank.jpg");
		salir = herramienta.getImage("imagenes\\salir.jpg");
		menu = herramienta.getImage("imagenes\\menu.jpg");
		setVisible(true);
	}

	public void paint(Graphics g) {
		// Dibujar la imagen
		g.drawImage(chessfight, 0, 0, this);
		g.drawImage(menu, 400, 75, this);
		g.drawImage(jugar, 479, 180, this);
		g.drawImage(help, 479, 260, this);
		g.drawImage(rank, 479, 340, this);
		g.drawImage(salir, 479, 420, this);

	}
}