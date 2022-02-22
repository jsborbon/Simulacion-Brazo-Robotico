package logica;

import presentacion.Controller;

public class ComprobarGancho {
	
	private boolean pinza;
	private String open;
	private String close;

	public ComprobarGancho(Controller controller) {
		pinza = false;
		open = "src/resources/ganchoAbierto.gif";
		close = "src/resources/ganchoCerrado.gif";

	}

	public void mirarGancho(int valuePinza) {

		if(valuePinza == 1) {
			pinza = true;
		} else {
			pinza = false;
		}
	}

	public String cambiarGancho(int valuePinza) {
		mirarGancho(valuePinza);
		if (!pinza) {
			return open;
		} else {
			return close;
		}
	}
}
