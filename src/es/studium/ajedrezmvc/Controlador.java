package es.studium.ajedrezmvc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Controlador implements WindowListener, MouseListener {
	Modelo modelo;
	MenuPrincipal MenuPrincipal;
	Tablero tablero;
	Ranking ranking;
	Ayuda ayuda;
	File sf = new File("images/ubuntu.wav");

	Controlador(Modelo m, MenuPrincipal mp) {
		this.modelo = m;
		this.MenuPrincipal = mp;

		this.MenuPrincipal.addWindowListener(this);
		this.MenuPrincipal.addMouseListener(this);

	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {

		if (tablero != null && tablero.frame.isActive()) {
			tablero.frame.setVisible(false);
		}
		else if (ayuda != null && ayuda.isActive())
			{
				ayuda.setVisible(false);
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

		if (MenuPrincipal.isActive()) {
			if (x > 479 && x < 671 && y > 180 && y < 242) {
				tablero = new Tablero();
				this.tablero.frame.addWindowListener(this);
				this.tablero.frame.addMouseListener(this);
			} else if (x > 479 && x < 671 && y > 260 && y < 322) {
				ayuda = new Ayuda();
				this.ayuda.addWindowListener(this);
			} else if (x > 479 && x < 671 && y > 340 && y < 402) {
				ranking = new Ranking();
				this.ranking.addWindowListener(this);
			} else if (x > 479 && x < 671 && y > 420 && y < 482) {
				 // Reproducir sonido
	            try {
	            	File sf = new File("images/ubuntu.wav");
	                AudioInputStream ais = AudioSystem.getAudioInputStream(sf);
	                AudioFormat af = ais.getFormat();
	                DataLine.Info info = new DataLine.Info(Clip.class, af);
	                Clip ol = (Clip) AudioSystem.getLine(info);
	                ol.open(ais);
	                ol.loop(1);
	                Thread.sleep(3000);
	                ol.close();
	            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
	                ex.printStackTrace();
	            } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}