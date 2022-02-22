package presentacion;

import javax.swing.JFrame;
import estructura.Articulacion;
import estructura.Base;
import estructura.Pinza;

public class Modelo {

	private Ventana vista;
	private Articulacion[] articulacion;
	private Pinza gancho;
	private Base basement;

	public Modelo() {
		articulacion = new Articulacion[4];
	}

	public Ventana getVista() {
		if (vista == null) {
			vista = new Ventana(this);
		}
		return vista;
	}

	public void iniciar() {
		crearBrazo();
		getVista().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getVista().setTitle("BRAZO ROBOTICO");
		getVista().setBounds(100, 100, 532, 406);
		getVista().setResizable(false);
		getVista().setLocationRelativeTo(null);
		getVista().setVisible(true);

	}

	public void crearBrazo() {
		basement = new Base();

		int sizeBrazo = 150; // tama�o brazo
                int sizeBrazoPinza = 20; // tamaño pinza
		int rotacion = 180; // rotacion inicial de la primera base
		int rotaInicial = 180;

		// CREACION DE LA BASE y DE LAS ARTICULACIONES

		for (int i = 0; i < articulacion.length; i++) {
			articulacion[i] = new Articulacion(sizeBrazo);
			articulacion[i].setRotacion(rotacion);

			if (i == 0) {

				articulacion[i].setCoord_x(basement.getCoord_xBase());
				articulacion[i].setCoord_z(3);
				articulacion[i].setRotaThis(rotaInicial);
			} else {
				articulacion[i].setCoord_x(articulacion[i - 1].getCoord_x());
				articulacion[i].setCoord_y(articulacion[i - 1].getCoord_y());
				articulacion[i].setCoord_z(articulacion[i - 1].getCoord_z());
				articulacion[i].setRotaThis(rotaInicial);
			}

		}

		gancho = new Pinza(articulacion[3].getCoord_x(), articulacion[3].getCoord_y(), articulacion[3].getCoord_z(),
				sizeBrazoPinza, rotacion, rotaInicial, rotaInicial);
	}

	public Articulacion[] getArticulacion() {
		return articulacion;
	}

	public Pinza getGancho() {
		return gancho;
	}

	public Base getBasement() {
		return basement;
	}

}
