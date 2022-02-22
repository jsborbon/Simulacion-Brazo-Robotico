package logica;

import java.text.DecimalFormat;

import estructura.Articulacion;
import estructura.Base;
import estructura.Pinza;
import presentacion.Controller;

public class CambiarDatos {

	Base basement;
	Articulacion art1;
	Articulacion art2;
	Articulacion art3;
	Articulacion art4;
	Pinza gancho;
	DecimalFormat dosDecimales;
	CalcularCoordenadas coordCalculator;
	RevisarMargenes checkBorders = new RevisarMargenes();
	Controller c;

	public CambiarDatos(Controller controller) {
		
		this.c = controller;
		dosDecimales = new DecimalFormat("0.00");
		coordCalculator = new CalcularCoordenadas();
	}

	public void inicializar(Articulacion art1, Articulacion art2, Articulacion art3, Articulacion art4, Pinza gancho,
			Base base) {
		this.basement = base;
		this.art1 = art1;
		this.art2 = art2;
		this.art3 = art3;
		this.art4 = art4;
		this.gancho = gancho;
	}

	public void modificarCoordenadas(int baseMovimiento, int rota1, int rota2, int rota3, int rota4, int rotacion) {

		// Modificar Base
		basement.setCoord_xBase(baseMovimiento);

		// Modificar Art 1
		art1.setRotacion(rotacion); // Modificar Rotacion
		art1.setRotaThis(rota1); // Modificar Rota
		art1.setCoord_x(calcularCoordenadaX(1)); // Modificar en x

		// Modificar Art 2
		art2.setRotacion(rotacion); // Modificar Rotacion
		art2.setRotaThis(rota2); // Modificar Rota
		art2.setCoord_x(calcularCoordenadaX(2)); // Modificar en x
		art2.setCoord_y(calcularCoordenadaY(2));// Modificar en y
		art2.setCoord_z(calcularCoordenadaZ(2));// Modificar en z

		// Modificar Art 3
		art3.setRotacion(rotacion); // Modificar Rotacion
		art3.setRotaThis(rota3); // Modificar Rota
		art3.setCoord_x(calcularCoordenadaX(3)); // Modificar en x
		art3.setCoord_y(calcularCoordenadaY(3));// Modificar en y
		art3.setCoord_z(calcularCoordenadaZ(3));// Modificar en z

		// Modificar Art 4
		art4.setRotacion(rotacion); // Modificar Rotacion
		art4.setRotaThis(rota4); // Modificar Rota
		art4.setCoord_x(calcularCoordenadaX(4)); // Modificar en x
		art4.setCoord_y(calcularCoordenadaY(4));// Modificar en y
		art4.setCoord_z(calcularCoordenadaZ(4));// Modificar en z

		// Modificar Gancho
		gancho.setRotacion(rotacion); // Modificar Rotacion
		gancho.setCoord_x(calcularCoordenadaX(5)); // Modificar en x
		gancho.setCoord_y(calcularCoordenadaY(5));// Modificar en y
		gancho.setCoord_z(calcularCoordenadaZ(5));// Modificar en z

	}

	private double calcularCoordenadaX(int i) {
		double coordenadasX;
		int rotacion = 0;
		double coordXPrev = 0;
		int rotaPrev = 0;
		float sizeBrazo = 0;

		switch (i) {
		case 1:
			rotacion = art1.getRotacion();
			coordXPrev = basement.getCoord_xBase();
			sizeBrazo = art1.getSizeBrazo();
			break;
		case 2:
			rotacion = art2.getRotacion();
			coordXPrev = art1.getCoord_x();
			rotaPrev = art1.getRotaThis();
			sizeBrazo = art2.getSizeBrazo();
			break;
		case 3:
			rotacion = art3.getRotacion();
			coordXPrev = art2.getCoord_x();
			rotaPrev =  art2.getRotaThis() + art1.getRotaThis();
			sizeBrazo = art3.getSizeBrazo();
			break;
		case 4:
			rotacion = art4.getRotacion();
			coordXPrev = art3.getCoord_x();
			rotaPrev = art3.getRotaThis() + art2.getRotaThis()+ art1.getRotaThis();
			sizeBrazo = art4.getSizeBrazo();
			break;
		case 5:
			rotacion = gancho.getRotacion();
			coordXPrev = art4.getCoord_x();
			rotaPrev = art4.getRotaThis() + art3.getRotaThis() + art2.getRotaThis()+ art1.getRotaThis();
			sizeBrazo = gancho.getSizeBrazo();
			break;

		}

		coordenadasX = coordCalculator.HallarCoordenadasX(i, rotacion, coordXPrev, rotaPrev, sizeBrazo);
		return coordenadasX;
	}

	private double calcularCoordenadaY(int i) {
		double coordenadasY;
		int rotacion = 0;
		double coordYPrev = 0;
		int rotaPrev = 0;
		float sizeBrazo = 0;

		switch (i) {
		case 1:
			rotacion = art1.getRotacion();
			coordYPrev = basement.getCoord_yBase();
			sizeBrazo = art1.getSizeBrazo();
			break;
		case 2:
			rotacion = art2.getRotacion();
			coordYPrev = art1.getCoord_y();
			rotaPrev = art1.getRotaThis();
			sizeBrazo = art2.getSizeBrazo();
			break;
		case 3:
			rotacion = art3.getRotacion();
			coordYPrev = art2.getCoord_y();
			rotaPrev = art2.getRotaThis() + art1.getRotaThis();
			sizeBrazo = art3.getSizeBrazo();
			break;
		case 4:
			rotacion = art4.getRotacion();
			coordYPrev = art3.getCoord_y();
			rotaPrev = art3.getRotaThis() + art2.getRotaThis()+ art1.getRotaThis();
			sizeBrazo = art4.getSizeBrazo();
			break;
		case 5:
			rotacion = gancho.getRotacion();
			coordYPrev = art4.getCoord_y();
			rotaPrev = art4.getRotaThis() + art3.getRotaThis() + art2.getRotaThis() + art1.getRotaThis();
			sizeBrazo = gancho.getSizeBrazo();
			break;

		}

		coordenadasY = coordCalculator.HallarCoordenadasY(i, rotacion, coordYPrev, rotaPrev, sizeBrazo);
		return coordenadasY;
	}

	private double calcularCoordenadaZ(int i) {
		double coordenadasZ;
		int rotacion = 0;
		double coordZPrev = 0;
		int rotaPrev = 0;
		float sizeBrazo = 0;

		switch (i) {
		case 1:
			rotacion = art1.getRotacion();
			coordZPrev = basement.getCoord_zBase();
			sizeBrazo = art1.getSizeBrazo();
			break;
		case 2:
			rotacion = art2.getRotacion();
			coordZPrev = art1.getCoord_z();
			rotaPrev = art1.getRotaThis();
			sizeBrazo = art2.getSizeBrazo();
			break;
		case 3:
			rotacion = art3.getRotacion();
			coordZPrev = art2.getCoord_z();
			rotaPrev = art2.getRotaThis() + art1.getRotaThis();
			sizeBrazo = art3.getSizeBrazo();
			break;
		case 4:
			rotacion = art4.getRotacion();
			coordZPrev = art3.getCoord_z();
			rotaPrev = art3.getRotaThis() + art2.getRotaThis() + art1.getRotaThis();
			sizeBrazo = art4.getSizeBrazo();
			break;
		case 5:
			rotacion = gancho.getRotacion();
			coordZPrev = art4.getCoord_z();
			rotaPrev = art4.getRotaThis() + art3.getRotaThis() + art2.getRotaThis() + art1.getRotaThis();
			sizeBrazo = gancho.getSizeBrazo();
			break;

		}

		coordenadasZ = coordCalculator.HallarCoordenadasZ(i, rotacion, coordZPrev, rotaPrev, sizeBrazo);
		return coordenadasZ;
	}

	public String[] devolverCoordenadas() {
		String[] grupoCoordenadas = new String[5];

		grupoCoordenadas[0] = "( " + dosDecimales.format(art1.getCoord_x()) + ", "
				+ dosDecimales.format(art1.getCoord_y()) + ", " + dosDecimales.format(art1.getCoord_z()) + ")";
		grupoCoordenadas[1] = "( " + dosDecimales.format(art2.getCoord_x()) + ", "
				+ dosDecimales.format(art2.getCoord_y()) + ", " + dosDecimales.format(art2.getCoord_z()) + ")";
		grupoCoordenadas[2] = "( " + dosDecimales.format(art3.getCoord_x()) + ", "
				+ dosDecimales.format(art3.getCoord_y()) + ", " + dosDecimales.format(art3.getCoord_z()) + ")";
		grupoCoordenadas[3] = "( " + dosDecimales.format(art4.getCoord_x()) + ", "
				+ dosDecimales.format(art4.getCoord_y()) + ", " + dosDecimales.format(art4.getCoord_z()) + ")";
		grupoCoordenadas[4] = "( " + dosDecimales.format(gancho.getCoord_x()) + ", "
				+ dosDecimales.format(gancho.getCoord_y()) + ", " + dosDecimales.format(gancho.getCoord_z()) + ")";

		return grupoCoordenadas;
	}

	public void comprobarMargenes() {
		double[] lsCoordenadasX = { art1.getCoord_x(), art2.getCoord_x(), art3.getCoord_x(), art4.getCoord_x(),
				gancho.getCoord_y() };
		double[] lsCoordenadasY = { art1.getCoord_y(), art2.getCoord_y(), art3.getCoord_y(), art4.getCoord_y(),
				gancho.getCoord_y() };
		double[] lsCoordenadasZ = { art1.getCoord_z(), art2.getCoord_z(), art3.getCoord_z(), art4.getCoord_z(),
				gancho.getCoord_z() };
		checkBorders.sonar(lsCoordenadasX, lsCoordenadasY, lsCoordenadasZ);

	}

}
