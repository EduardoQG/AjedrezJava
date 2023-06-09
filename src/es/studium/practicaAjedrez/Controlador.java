package es.studium.practicaAjedrez;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, MouseListener {

	ModeloAjedrez modelo;
	VistaMenuPrincipal menuPrincipal;
	VistaTablero tablero;
	VistaRanking ranking;
	Casilla casilla;

	boolean partidaTerminada;
	boolean turnoBlancas;
	Casilla casillaSeleccionada;
	boolean elegirMovimiento;
	Ficha fichaMover;

	Controlador(ModeloAjedrez m, VistaMenuPrincipal mp) {

		this.modelo = m;
		this.menuPrincipal = mp;

		this.menuPrincipal.addWindowListener(this);
		this.menuPrincipal.addMouseListener(this);
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {

		if (tablero != null && tablero.frame.isActive()) {
			tablero.frame.setVisible(false);
		}

		else if (ranking != null && ranking.isActive()) {
			ranking.setVisible(false);
		} else {
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
		int x = me.getX() - 7;
		int y = me.getY() - 30;
		
		if (menuPrincipal.isActive()) {
			if (x > 479 && x < 671 && y > 180 && y < 242) {
				tablero = new VistaTablero();
				this.tablero.frame.addWindowListener(this);
				this.tablero.frame.addMouseListener(this);
				turnoBlancas = true;
				partidaTerminada = false;
			
			} else if (x > 479 && x < 671 && y > 260 && y < 322) {
				// Se abre fichero ayuda.
			} else if (x > 479 && x < 671 && y > 340 && y < 402) {
				ranking = new VistaRanking();
				this.ranking.addWindowListener(this);
			} else if (x > 479 && x < 671 && y > 420 && y < 482) {
				System.exit(0);
			}

		} else if (tablero.frame.isActive() && !partidaTerminada) {
			casillaSeleccionada = modelo.getCasillaSeleccionada(this, x, y);

			}
			
			// Le toca al jugador blanco, este debe hacer click en una celda.
			if (turnoBlancas) { 
				 
				// Para que se  mueva la ficha, debe clickar en una celda ocupada, cuya ficha sea blanca.
				// **Se podría hacer que cuando se seleccione una casilla válida, se pinte el fondo de verde.
				if (casillaSeleccionada != null && casillaSeleccionada.getFicha() != null && 
						casillaSeleccionada.getFicha().getEsBlanca()) {
					fichaMover = casillaSeleccionada.getFicha();
					
				// Si ya se ha seleccionado una ficha a mover y la casilla seleccionada está vacía o tiene
				// una ficha negra.
				} else if (fichaMover != null && casillaSeleccionada != null && (casillaSeleccionada.getFicha() == null ||
						casillaSeleccionada.getFicha().getEsBlanca() == false)) {
					
					
					if (comprobarMovimientoValido(fichaMover, casillaSeleccionada)) {
						
						if (casillaSeleccionada.getFicha() != null) {
							casillaSeleccionada.getFicha().morir();
						}
						fichaMover.setCasillaActual(casillaSeleccionada);
						tablero.repaint();
						fichaMover = null;
					}
				}
				
			}	 	 
			
		}
	

	

	private boolean comprobarMovimientoValido(Ficha fichaMover, Casilla casillaSeleccionada) {
		
		// MOVIMIENTO PEON BLANCO:
		// Si la ficha es un 1.peon, 2.es blanca, 3.la casilla a la que la mueve es el index y - 1
		// 4.y esta casilla no está ocupada por otra ficha blanca o negra, el movimiento es válido.
		if (fichaMover.getTipoFicha().equals("peon") && fichaMover.getEsBlanca()
				&& casillaSeleccionada.y == fichaMover.getCasillaActual().y + 50
				&& casillaSeleccionada.x == fichaMover.getCasillaActual().x
				&& casillaSeleccionada.getFicha() == null) {
			
				return true;
		}
		
		// PEON BLANCO COMER:
		
		else if (fichaMover.getTipoFicha().equals("peon") && fichaMover.getEsBlanca()
				// Si se mueve una casilla en diagonal hacia cualquiera de los lados.
				&& (casillaSeleccionada.y == fichaMover.getCasillaActual().y + 50 &&
				(casillaSeleccionada.x == fichaMover.getCasillaActual().x + 50) || 
				casillaSeleccionada.x == fichaMover.getCasillaActual().x - 50)
				// Si la ficha de la casilla es negra.
				&& casillaSeleccionada.getFicha() != null && 
				!casillaSeleccionada.getFicha().getEsBlanca()) {
			
				return true;
		}
		
		
		// MOVIMIENTO TORRE BLANCA: !!! POR ALGUNA RAZÓN NO FUNCIONA
		
		 		// Si la ficha a mover es una torre blanca,
		else if (fichaMover.getTipoFicha().equals("torre") && fichaMover.getEsBlanca()
				// el movimiento es en línea
				&& ((casillaSeleccionada.x != fichaMover.getCasillaActual().x && 
				casillaSeleccionada.y == fichaMover.getCasillaActual().y) ||
				(casillaSeleccionada.x == fichaMover.getCasillaActual().x &&
				casillaSeleccionada.y != fichaMover.getCasillaActual().y)) && 
				// el camino está vacío
				 caminoVacio(fichaMover, fichaMover.getCasillaActual().x, casillaSeleccionada.x, 
						 fichaMover.getCasillaActual().y, casillaSeleccionada.y) ) {
				return true;		
		}
		
		
		return false;
	}
	
	private boolean caminoVacio(Ficha ficha, int oldX, int newX, int oldY, int newY) {
		
		if (ficha.getTipoFicha().equals("torre")) {
			
			if (oldX == newX) {
				if (oldY < newY) {
					for (int i = oldY+50; i < newY; i+=50) {
						if (getCasillaPorCoordenadas(oldX, i).getFicha() != null) {
							return false;
						}
					}
				} else if (oldY > newY) {
					for (int i = oldY-50; i > newY; i-=50) {
						if (getCasillaPorCoordenadas(oldX, i).getFicha() != null) {
							return false;
						}
					}	
				}
			} else if (oldY == newY) {
				if (oldX < newX) {
					for (int i = oldX+50; i < newX; i+=50) {
						if (getCasillaPorCoordenadas(i, oldY).getFicha() != null) {
							return false;
						}
					}
				} else if (oldX > newX) {
					for (int i = oldX-50; i > newX; i-=50) {
						if (getCasillaPorCoordenadas(i, oldY).getFicha() != null) {
							return false;
					
						}
					}
				}
				
			}
		}
		
		return true;
	}

	private Casilla getCasillaPorCoordenadas(int x, int y) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (tablero.casillas[i][j].x == x && tablero.casillas[i][j].y == y) {
					return tablero.casillas[i][j];
				}
			}
		}
		
		
		return null;
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
