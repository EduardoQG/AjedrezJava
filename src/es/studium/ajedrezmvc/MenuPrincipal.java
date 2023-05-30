package es.studium.ajedrezmvc;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class MenuPrincipal extends Frame {
	private static final long serialVersionUID = 1L;
	Image jugar, help, rank, salir, menu, chessfight;
	Toolkit herramienta;
	MenuPrincipal()
	{
		setSize(1200, 675);
		setResizable(false);
		setLocationRelativeTo(null);
		herramienta = getToolkit();
		chessfight = herramienta.getImage("images\\chessfight.jpeg");
		jugar = herramienta.getImage("images\\jugar.jpg");
		help = herramienta.getImage("images\\help.jpg");
		rank = herramienta.getImage("images\\rank.jpg");
		salir = herramienta.getImage("images\\salir.jpg");
		menu = herramienta.getImage("images\\menu.jpg");
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
