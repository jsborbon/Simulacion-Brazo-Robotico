package presentacion;

import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logica.CambiarDatos;
import logica.ComprobarGancho;

public class Controller implements ChangeListener {

	private Ventana vista;
	private Modelo model;
	private CambiarDatos changeData;
	private ComprobarGancho checkGripper;

	public Controller(Ventana window) {
		this.vista = window;
		model=window.getModel();
		this.getChangeData().inicializar(model.getArticulacion()[0], model.getArticulacion()[1], model.getArticulacion()[2],
				model.getArticulacion()[3], model.getGancho(), model.getBasement());		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		establecerCoordenadas();

	}

	public CambiarDatos getChangeData() {
		if (changeData == null) {
			changeData = new CambiarDatos(this);
		}
		return changeData;
	}

	public ComprobarGancho getCheckGripper() {
		if (checkGripper == null) {
			checkGripper = new ComprobarGancho(this);
		}
		return checkGripper;
	}

	public void establecerCoordenadas() {

		getChangeData().modificarCoordenadas(vista.getSliderBase().getValue(), vista.getSliderArt1().getValue(),
				vista.getSliderArt2().getValue(), vista.getSliderArt3().getValue(), vista.getSliderArt4().getValue(),
				vista.getSliderRotacion().getValue());
		getChangeData().comprobarMargenes();
		ImageIcon imagen = new ImageIcon(getCheckGripper().cambiarGancho(vista.getSliderPinza().getValue()));
		vista.getLblPicture().setIcon(imagen);
        editarDescripcionLabel(imagen);
		editarCoordenadas(getChangeData().devolverCoordenadas());
	}

	private void editarDescripcionLabel(ImageIcon imagen) {
        if(imagen.toString().equals("/resources/ganchoAbierto.gif")){
            vista.getLblPicture().setText("Gancho Abierto");
        }else{
            vista.getLblPicture().setText("Gancho Cerrado");
        }

	}


	private void editarCoordenadas(String[] grupoCoordenadas) {

		for (int i = 0; i < vista.getTxtFieldCoordenadas().length; i++) {
			vista.getTxtFieldCoordenadas()[i].setText(grupoCoordenadas[i]);
		}

	}

}
