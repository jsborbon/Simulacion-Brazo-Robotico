package logica;

public class RevisarMargenes {

	private Sonido sound = new Sonido();
	private boolean IsSound;

	public RevisarMargenes() {
		IsSound = false;

	}

	public boolean revisarMargenesExcedidas(double[] lsCoordenadasX, double[] lsCoordenadasY, double[] lsCoordenadasZ) {

		for (int i = 0; i < 5; i++) {
			if (Math.abs(lsCoordenadasX[i]) > 400 || Math.abs(lsCoordenadasY[i]) > 400 || lsCoordenadasZ[i] < 0) {
				return true;
			}
		}
		return false;
	}

	public void sonar(double[] lsCoordenadasX, double[] lsCoordenadasY, double[] lsCoordenadasZ) {

		if (revisarMargenesExcedidas(lsCoordenadasX, lsCoordenadasY, lsCoordenadasZ)) {
			sound.play();
			IsSound = true;
		} else {
			sound.stop(IsSound);
			IsSound = false;
		}

	}

}
