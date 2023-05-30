package es.studium.practicaAjedrez;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;


public class Controlador implements WindowListener, MouseListener {
	
	ModeloAjedrez modelo;
	VistaMenuPrincipal menuPrincipal;
	VistaTablero tablero;
	VistaRanking ranking;
	
	File sf = new File("images/ubuntu.wav");

	Controlador(ModeloAjedrez m, VistaMenuPrincipal mp) {
		
		this.modelo = m;
		this.menuPrincipal = mp;

		this.menuPrincipal.addWindowListener(this);
		this.menuPrincipal.addMouseListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {

		if (tablero != null && tablero.frame.isActive()) {
			tablero.frame.setVisible(false);
		}
		
		else if (ranking != null && ranking.isActive())
		{
			ranking.setVisible(false);
		}
		 else {
			System.exit(0);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		int x = me.getX();
		int y = me.getY();

		if (menuPrincipal.isActive()) {
			if (x > 479 && x < 671 && y > 180 && y < 242) {
				tablero = new VistaTablero();
				this.tablero.frame.addWindowListener(this);
				this.tablero.frame.addMouseListener(this);
			} else if (x > 479 && x < 671 && y > 260 && y < 322) {
				
			} else if (x > 479 && x < 671 && y > 340 && y < 402) {
				ranking = new VistaRanking();
				this.ranking.addWindowListener(this);
			} else if (x > 479 && x < 671 && y > 420 && y < 482) {
				System.exit(0);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
