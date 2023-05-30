package es.studium.practicaAjedrez;

public class Principal {

	public static void main(String[] args) {
		
		ModeloAjedrez modelo = new ModeloAjedrez();
		VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal();

		new Controlador(modelo, menuPrincipal);
	}

}
