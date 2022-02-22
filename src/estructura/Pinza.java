package estructura;

public class Pinza {

	private double coord_x;
	private double coord_y;
	private double coord_z;
	private int rotacion;
	private boolean isOpen;
	private float sizeBrazo;

	public Pinza(double coord_x4, double coord_y4, double coord_z4, int sizeBrazo, int rotacion, int rota3, int rota4) {
		this.coord_x = coord_x4 + 20 * Math.sin(270 - rota3 - rota4) * Math.cos(rotacion);
		this.coord_y = coord_y4 + 20 * Math.sin(270 - rota3 - rota4) * Math.sin(rotacion);
		this.coord_z = (coord_z4 + 3) + 20 * Math.sin(270 - rota3 - rota4);
		this.rotacion = rotacion;
		this.isOpen = false;
		this.sizeBrazo = sizeBrazo;
	}

	public double getCoord_x() {
		return coord_x;
	}

	public void setCoord_x(double coord_x) {
		this.coord_x = coord_x;
	}

	public double getCoord_y() {
		return coord_y;
	}

	public void setCoord_y(double coord_y) {
		this.coord_y = coord_y;
	}

	public double getCoord_z() {
		return coord_z;
	}

	public void setCoord_z(double coord_z) {
		this.coord_z = coord_z;
	}

	public int getRotacion() {
		return rotacion;
	}

	public void setRotacion(int rotacion) {
		this.rotacion = rotacion;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public float getSizeBrazo() {
		return sizeBrazo;
	}

	public void setSizeBrazo(float sizeBrazo) {
		this.sizeBrazo = sizeBrazo;
	}

}
