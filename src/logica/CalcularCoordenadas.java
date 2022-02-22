package logica;

public class CalcularCoordenadas {


	public double HallarCoordenadasX(int i, int rotacion, double coordXPrev, int rotaPrev, float sizeBrazo) {
		double coordenadas = 0;
		if (i == 1) {
			coordenadas = coordXPrev;
		}else {
                        coordenadas = coordXPrev + sizeBrazo * Math.sin(Math.toRadians(90+180*(i-2) - rotaPrev)) * Math.cos(Math.toRadians(rotacion));
		}
		return coordenadas;
	}

	public double HallarCoordenadasY(int i, int rotacion, double coordYPrev, int rotaPrev, float sizeBrazo) {
		double coordenadas = 0;
		if (i == 1) {
                        coordenadas = coordYPrev;
		}else {
                        coordenadas = coordYPrev + sizeBrazo * Math.sin(Math.toRadians(90+180*(i-2) - rotaPrev)) * Math.sin(Math.toRadians(rotacion));
		}
		return coordenadas;
	}

	public double HallarCoordenadasZ(int i, int rotacion, double coordZPrev, int rotaPrev, float sizeBrazo) {
		double coordenadas = 0;
		if (i == 1) {
			coordenadas = coordZPrev + 3;
		}else {
			coordenadas = (coordZPrev + 3) + sizeBrazo * Math.cos(Math.toRadians(90+180*(i-2) - rotaPrev));
		}
		return coordenadas;
	}
}
