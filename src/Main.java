import presentacion.Modelo;

public class Main {

	private Modelo miApp;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		miApp = new Modelo();
		miApp.iniciar();
	}
}