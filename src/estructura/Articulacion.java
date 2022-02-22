package estructura;

public class Articulacion {

	private double coord_x;
	private double coord_y;
	private double coord_z;
	private float sizeBrazo;
	private int rotacion;
	private int rotaThis;

	public Articulacion(int sizeBrazo) {
		this.coord_x = 0;
		this.coord_y = 0;
		this.coord_z = 0;
		this.rotacion = 0;
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

	public float getSizeBrazo() {
		return sizeBrazo;
	}

	public void setSizeBrazo(float sizeBrazo) {
		this.sizeBrazo = sizeBrazo;
	}

	public int getRotacion() {
		return rotacion;
	}

	public void setRotacion(int rotacion) {
		this.rotacion = rotacion;
	}

	public int getRotaThis() {
		return rotaThis;
	}

	public void setRotaThis(int rotaThis) {
		this.rotaThis = rotaThis;
	}

}
