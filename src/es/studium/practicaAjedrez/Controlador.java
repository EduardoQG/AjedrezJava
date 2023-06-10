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

	int movimientoX;
	int movimientoY;

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

			// Si se ha clickado en una casilla, dicha casilla no está vacía,
			if (casillaSeleccionada != null && casillaSeleccionada.getFicha() != null) {
				// y el color de la ficha corresponde con el turno,
				if ((casillaSeleccionada.getFicha().getEsBlanca() && turnoBlancas)
						|| !casillaSeleccionada.getFicha().getEsBlanca() && !turnoBlancas) {
					// se selecciona esa ficha.
					fichaMover = casillaSeleccionada.getFicha();
				}
				// Si ya se ha seleccionado una ficha a mover y una casilla, 
			} else if (fichaMover != null && casillaSeleccionada != null) {
				// y esa casilla está vacía o tiene una ficha del color contrario.
				if ((turnoBlancas && (casillaSeleccionada.getFicha() == null || !casillaSeleccionada.getFicha().getEsBlanca())) 
						|| (!turnoBlancas && (casillaSeleccionada.getFicha() == null || casillaSeleccionada.getFicha().getEsBlanca()))){
					
					if (comprobarMovimientoValido(fichaMover, casillaSeleccionada)) {

						if (casillaSeleccionada.getFicha() != null) {
							casillaSeleccionada.getFicha().morir();
						}
						fichaMover.setCasillaActual(casillaSeleccionada);
						// Cambiar turno:
						if (turnoBlancas) {turnoBlancas = false;} else { turnoBlancas = true;}
						tablero.repaint();
						fichaMover = null;
						
					}					
				}
			}
		}

	}

	private boolean comprobarMovimientoValido(Ficha fichaMover, Casilla casillaSeleccionada) {

		movimientoX = Math.abs(casillaSeleccionada.x - fichaMover.getCasillaActual().x);
		movimientoY = Math.abs(casillaSeleccionada.y - fichaMover.getCasillaActual().y);

		// MOVIMIENTO PEON:
		if (fichaMover.getTipoFicha().equals("peon")) {
			
			if(fichaMover.getEsBlanca()) {
				// Si el movimiento es de una casilla hacia abajo, y esa casilla no está ocupada.
				if(casillaSeleccionada.y == fichaMover.getCasillaActual().y + 50 && movimientoX == 0 
						&& casillaSeleccionada.getFicha() == null) {
					return true;
				// Si el movimiento es una casilla en diagonal hacia abajo, y esa casilla está
				// ocupada por una pieza del color contrario.
				} else if (casillaSeleccionada.y == fichaMover.getCasillaActual().y + 50 && movimientoX == 50 
						&& casillaSeleccionada.getFicha() != null && !casillaSeleccionada.getFicha().getEsBlanca()) {
					return true;
				}
			
			} else {
				if(casillaSeleccionada.y == fichaMover.getCasillaActual().y - 50 && movimientoX == 0 
						&& casillaSeleccionada.getFicha() == null) {
					return true;
				} else if (casillaSeleccionada.y == fichaMover.getCasillaActual().y - 50 && movimientoX == 50 
						&& casillaSeleccionada.getFicha() != null && casillaSeleccionada.getFicha().getEsBlanca()) {
					return true;
				}
			}

		}

		// MOVIMIENTO TORRE:

		// Si la ficha a mover es una torre,
		else if (fichaMover.getTipoFicha().equals("torre")
		// El movimiento de un eje varía y el del otro no (movimiento en línea)
				&& ((movimientoX == 0 && movimientoY != 0) || (movimientoX != 0 && movimientoY == 0))
				&& caminoVacio(fichaMover, fichaMover.getCasillaActual().x, casillaSeleccionada.x,
						fichaMover.getCasillaActual().y, casillaSeleccionada.y)) {
			return true;
		}

		// MOVIMIENTO CABALLO:
		else if (fichaMover.getTipoFicha().equals("caballo")
		// Si el movimiento total de x e y suma 150 y no son 0 (movimiento en L):
				&& movimientoX + movimientoY == 150 && movimientoX != 0 && movimientoY != 0) {
			return true;
		}

		// MOVIMIENTO ALFIL:
		else if (fichaMover.getTipoFicha().equals("alfil") &&
		// Si el movimiento de una y otra suman lo mismo (movimiento diagonal):
				(movimientoX == movimientoY) && caminoVacio(fichaMover, fichaMover.getCasillaActual().x,
						casillaSeleccionada.x, fichaMover.getCasillaActual().y, casillaSeleccionada.y)) {
			return true;

			// MOVIMIENTO REINA BLANCA:
		} else if (fichaMover.getTipoFicha().equals("reina") &&
		// Si el movimiento es el de la torre o el del alfil:
				(((movimientoX == 0 && movimientoY != 0) || (movimientoX != 0 && movimientoY == 0))
						|| (movimientoX == movimientoY))
				&& caminoVacio(fichaMover, fichaMover.getCasillaActual().x, casillaSeleccionada.x,
						fichaMover.getCasillaActual().y, casillaSeleccionada.y)) {
			return true;

			// MOVIMIENTO REY BLANCO:
		} else if (fichaMover.getTipoFicha().equals("rey") &&
		// Si el movimiento es el de la torre o el del alfil y nunca es mayor de 50 en
		// los ejes (1 casilla):
				(((movimientoX == 0 && movimientoY != 0) || (movimientoX != 0 && movimientoY == 0))
						|| (movimientoX == movimientoY))
				&& (movimientoX <= 50 && movimientoY <= 50) && caminoVacio(fichaMover, fichaMover.getCasillaActual().x,
						casillaSeleccionada.x, fichaMover.getCasillaActual().y, casillaSeleccionada.y)) {
			return true;

		}

		return false;
	}

	private boolean caminoVacio(Ficha ficha, int oldX, int newX, int oldY, int newY) {

		movimientoX = Math.abs(casillaSeleccionada.x - fichaMover.getCasillaActual().x);
		movimientoY = Math.abs(casillaSeleccionada.y - fichaMover.getCasillaActual().y);

		// COMPROBAR CAMINO TORRE:
		if (ficha.getTipoFicha().equals("torre")) {

			if (oldX == newX) {
				if (oldY < newY) {
					for (int i = oldY + 50; i < newY; i += 50) {
						if (getCasillaPorCoordenadas(oldX, i).getFicha() != null) {
							return false;
						}
					}
				} else if (oldY > newY) {
					for (int i = oldY - 50; i > newY; i -= 50) {
						if (getCasillaPorCoordenadas(oldX, i).getFicha() != null) {
							return false;
						}
					}
				}
			} else if (oldY == newY) {
				if (oldX < newX) {
					for (int i = oldX + 50; i < newX; i += 50) {
						if (getCasillaPorCoordenadas(i, oldY).getFicha() != null) {
							return false;
						}
					}
				} else if (oldX > newX) {
					for (int i = oldX - 50; i > newX; i -= 50) {
						if (getCasillaPorCoordenadas(i, oldY).getFicha() != null) {
							return false;

						}
					}
				}

			}

			// COMPROBAR CAMINO ALFIL:
		} else if (ficha.getTipoFicha().equals("alfil")) {

			if (oldX < newX) {
				if (oldY < newY) {
					for (int i = oldX + 50, j = oldY + 50; i < newX; i += 50) {
						if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
							return false;

						}
						j += 50;
					}
				} else if (oldY > newY) {
					for (int i = oldX + 50, j = oldY - 50; i < newX; i += 50) {
						if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
							return false;
						}
						j -= 50;
					}

				}

			} else if (oldX > newX) {
				if (oldY < newY) {
					for (int i = oldX - 50, j = oldY + 50; i > newX; i -= 50) {
						if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
							return false;
						}
						j += 50;
					}
				} else if (oldY > newY) {
					for (int i = oldX - 50, j = oldY - 50; i > newX; i -= 50) {
						if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
							return false;
						}
						j -= 50;
					}
				}

			}

			// COMPROBAR CAMINO REINA:
		} else if (ficha.getTipoFicha().equals("reina")) {

			// MOVIMIENTO EN LÍNEA:
			if (movimientoX == 0 || movimientoY == 0) {

				if (oldX == newX) {
					if (oldY < newY) {
						for (int i = oldY + 50; i < newY; i += 50) {
							if (getCasillaPorCoordenadas(oldX, i).getFicha() != null) {
								return false;
							}
						}
					} else if (oldY > newY) {
						for (int i = oldY - 50; i > newY; i -= 50) {
							if (getCasillaPorCoordenadas(oldX, i).getFicha() != null) {
								return false;
							}
						}
					}
				} else if (oldY == newY) {
					if (oldX < newX) {
						for (int i = oldX + 50; i < newX; i += 50) {
							if (getCasillaPorCoordenadas(i, oldY).getFicha() != null) {
								return false;
							}
						}
					} else if (oldX > newX) {
						for (int i = oldX - 50; i > newX; i -= 50) {
							if (getCasillaPorCoordenadas(i, oldY).getFicha() != null) {
								return false;

							}
						}
					}

				}
			} else if (movimientoX == movimientoY) {
				if (oldX < newX) {
					if (oldY < newY) {
						for (int i = oldX + 50, j = oldY + 50; i < newX; i += 50) {
							if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
								return false;
							}
							j += 50;
						}
					} else if (oldY > newY) {
						for (int i = oldX + 50, j = oldY - 50; i < newX; i += 50) {
							if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
								return false;
							}
							j -= 50;
						}

					}
				} else if (oldX > newX) {
					if (oldY < newY) {
						for (int i = oldX - 50, j = oldY + 50; i > newX; i -= 50) {
							if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
								return false;
							}
							j += 50;
						}
					} else if (oldY > newY) {
						for (int i = oldX - 50, j = oldY - 50; i > newX; i -= 50) {
							if (getCasillaPorCoordenadas(i, j).getFicha() != null) {
								return false;
							}
							j -= 50;
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
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
