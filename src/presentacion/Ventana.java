package presentacion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	private Controller mando;
	private Modelo model;

	private JPanel contentPane;
	private JPanel panelInteraccion;
	private JPanel panelGrafico;
	private JTextField[] txtFieldCoordenadas;
	private JLabel[] lblListCoordenadas;
	private JLabel[] lblListCoordenadas2;
	private JSlider sliderRotacion;
	private JSlider sliderPinza;
	private JSlider sliderBase;
	private JSlider sliderArt1;
	private JSlider sliderArt2;
	private JSlider sliderArt3;
	private JSlider sliderArt4;
	private JLabel lblPicture;


	public Ventana(Modelo modelo) {
		
		this.model=modelo;
		initComponents();
                
                sliderArt1.setValue(75);
                sliderArt2.setValue(110);
                sliderArt3.setValue(145);
                sliderArt4.setValue(110);

	}

	private void initComponents() {

		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);

		panelGrafico = new JPanel();
		panelGrafico.setBounds(0, 0, 526, 160);
		contentPane.add(panelGrafico);
		panelGrafico.setLayout(null);
		panelGrafico.setVisible(true);

		lblPicture = new JLabel("Gancho");
		lblPicture.setBackground(Color.PINK);
		lblPicture.setForeground(Color.BLACK);
		lblPicture.setBounds(27, 11, 175, 138);
		panelGrafico.add(lblPicture);

		JLabel lblTitleCoordenadas = new JLabel("Coordenadas");
		lblTitleCoordenadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleCoordenadas.setBounds(379, 11, 86, 14);
		panelGrafico.add(lblTitleCoordenadas);

		JLabel lblNumberArticulacion = new JLabel("# Articulación");
		lblTitleCoordenadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberArticulacion.setBounds(240, 11, 93, 14);
		panelGrafico.add(lblNumberArticulacion);

		txtFieldCoordenadas = new JTextField[5];
		lblListCoordenadas = new JLabel[5];
		for (int i = 0; i < txtFieldCoordenadas.length; i++) {
			lblListCoordenadas[i] = new JLabel("Articulación " + (i + 1));
			txtFieldCoordenadas[i] = new JTextField("(x , y , z)");
			txtFieldCoordenadas[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblListCoordenadas[i].setBounds(240, 30 + (i * 25), 86, 20);
			txtFieldCoordenadas[i].setBounds(350, 30 + (i * 25), 150, 20);
			txtFieldCoordenadas[i].setEditable(false);
			txtFieldCoordenadas[i].setToolTipText("(x, y ,z)");
			if(i==4) {
				lblListCoordenadas[i].setText("  Pinza");
			}
			panelGrafico.add(lblListCoordenadas[i]);
			panelGrafico.add(txtFieldCoordenadas[i]);
		}

		panelInteraccion = new JPanel();
		panelInteraccion.setBounds(0, 163, 526, 215);
		contentPane.add(panelInteraccion);
		panelInteraccion.setLayout(null);
		panelInteraccion.setVisible(true);

		JLabel lblSliderBase = new JLabel("Movimiento Base");
		lblSliderBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblSliderBase.setBounds(10, 5, 200, 14);
		panelInteraccion.add(lblSliderBase);

		JLabel lblSlider0 = new JLabel("-400");
		lblSlider0.setBounds(14, 45, 25, 26);
		panelInteraccion.add(lblSlider0);

		JLabel lblSlider1 = new JLabel("400");
		lblSlider1.setBounds(191, 45, 35, 26);
		panelInteraccion.add(lblSlider1);

		sliderBase = new JSlider();
		sliderBase.setMinimum(-400);
		sliderBase.setMaximum(400);
		sliderBase.setValue(0);
		sliderBase.setToolTipText("Movimiento lateral base");
		sliderBase.setBounds(10, 25, 200, 26);
		sliderBase.addChangeListener(getMando());
		panelInteraccion.add(sliderBase);

		sliderRotacion = new JSlider();
		sliderRotacion.setToolTipText("Rotación Brazo");
		sliderRotacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderRotacion.setMaximum(360);
		sliderRotacion.setBounds(10, 87, 200, 44);
		sliderRotacion.setMajorTickSpacing(90);
		sliderRotacion.setMinorTickSpacing(45);
		sliderRotacion.setPaintTicks(true);
		sliderRotacion.setPaintLabels(true);
		sliderRotacion.setValue(180);
		sliderRotacion.addChangeListener(getMando());
		panelInteraccion.add(sliderRotacion);

		JLabel lblRotacion = new JLabel("Rotación");
		lblRotacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotacion.setBounds(10, 67, 200, 14);
		panelInteraccion.add(lblRotacion);

		JLabel lblPinza = new JLabel("Pinza");
		lblPinza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinza.setBounds(10, 134, 200, 14);
		panelInteraccion.add(lblPinza);

		sliderPinza = new JSlider();
		sliderPinza.setToolTipText("(Abrir / Cerrar)");
		sliderPinza.setValue(0);
		sliderPinza.setMaximum(1);
		sliderPinza.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderPinza.addChangeListener(getMando());
		sliderPinza.setBounds(10, 150, 200, 26);

		panelInteraccion.add(sliderPinza);

		JLabel lblSliderOpen = new JLabel("ABIERTO");
		lblSliderOpen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSliderOpen.setBounds(0, 172, 55, 26);
		panelInteraccion.add(lblSliderOpen);

		JLabel lblSliderClose = new JLabel("CERRADO");
		lblSliderClose.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSliderClose.setBounds(180, 172, 55, 26);
		panelInteraccion.add(lblSliderClose);

		JLabel lblArticulacion = new JLabel("Movimiento Articulación");
		lblArticulacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticulacion.setBounds(304, 5, 200, 14);
		panelInteraccion.add(lblArticulacion);

		JLabel lblNumberArt = new JLabel("# Articulacion");
		lblNumberArt.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberArt.setBounds(220, 5, 93, 14);
		panelInteraccion.add(lblNumberArt);

		lblListCoordenadas2 = new JLabel[4];
		for (int i = 0; i < lblListCoordenadas2.length; i++) {
			lblListCoordenadas2[i] = new JLabel("# " + (i + 1));
			lblListCoordenadas2[i].setBounds(239, 25 + (i * 45), 86, 20);
			lblListCoordenadas2[i].setHorizontalAlignment(SwingConstants.CENTER);
			panelInteraccion.add(lblListCoordenadas2[i]);
		}

		sliderArt1 = new JSlider();
		sliderArt1.setMinimum(5);
		sliderArt1.setToolTipText("Articulación 1");
		sliderArt1.setValue(180);
		sliderArt1.setPaintTicks(true);
		sliderArt1.setPaintLabels(true);
		sliderArt1.setMaximum(175);
		sliderArt1.setMajorTickSpacing(35);
		sliderArt1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderArt1.setBounds(314, 25, 200, 44);
		sliderArt1.addChangeListener(getMando());
		panelInteraccion.add(sliderArt1);

		sliderArt2 = new JSlider();
		sliderArt2.setMinimum(5);
		sliderArt2.setToolTipText("Articulación 2");
		sliderArt2.setValue(180);
		sliderArt2.setPaintTicks(true);
		sliderArt2.setPaintLabels(true);
		sliderArt2.setMaximum(175);
		sliderArt2.setMajorTickSpacing(35);
		sliderArt2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderArt2.setBounds(314, 69, 200, 44);
		sliderArt2.addChangeListener(getMando());
		panelInteraccion.add(sliderArt2);

		sliderArt3 = new JSlider();
		sliderArt3.setMinimum(5);
		sliderArt3.setToolTipText("Articulación 3");
		sliderArt3.setValue(180);
		sliderArt3.setPaintTicks(true);
		sliderArt3.setPaintLabels(true);
		sliderArt3.setMaximum(175);
		sliderArt3.setMajorTickSpacing(35);
		sliderArt3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderArt3.setBounds(314, 108, 200, 44);
		sliderArt3.addChangeListener(getMando());
		panelInteraccion.add(sliderArt3);

		sliderArt4 = new JSlider();
		sliderArt4.setValue(180);
		sliderArt4.setToolTipText("Articulación 4");
		sliderArt4.setPaintTicks(true);
		sliderArt4.setPaintLabels(true);
		sliderArt4.setMinimum(5);
		sliderArt4.setMaximum(175);
		sliderArt4.setMajorTickSpacing(35);
		sliderArt4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderArt4.setBounds(314, 148, 200, 44);
		sliderArt4.addChangeListener(getMando());
		panelInteraccion.add(sliderArt4);
		getMando().establecerCoordenadas();
	}

	
	
	public JTextField[] getTxtFieldCoordenadas() {
		return txtFieldCoordenadas;
	}

	public void setTxtFieldCoordenadas(JTextField[] txtFieldCoordenadas) {
		this.txtFieldCoordenadas = txtFieldCoordenadas;
	}

	public JSlider getSliderRotacion() {
		return sliderRotacion;
	}

	public void setSliderRotacion(JSlider sliderRotacion) {
		this.sliderRotacion = sliderRotacion;
	}

	public JSlider getSliderPinza() {
		return sliderPinza;
	}

	public void setSliderPinza(JSlider sliderPinza) {
		this.sliderPinza = sliderPinza;
	}

	public JSlider getSliderBase() {
		return sliderBase;
	}

	public void setSliderBase(JSlider sliderBase) {
		this.sliderBase = sliderBase;
	}

	public JSlider getSliderArt1() {
		return sliderArt1;
	}

	public void setSliderArt1(JSlider sliderArt1) {
		this.sliderArt1 = sliderArt1;
	}

	public JSlider getSliderArt2() {
		return sliderArt2;
	}

	public void setSliderArt2(JSlider sliderArt2) {
		this.sliderArt2 = sliderArt2;
	}

	public JSlider getSliderArt3() {
		return sliderArt3;
	}

	public void setSliderArt3(JSlider sliderArt3) {
		this.sliderArt3 = sliderArt3;
	}

	public JSlider getSliderArt4() {
		return sliderArt4;
	}

	public void setSliderArt4(JSlider sliderArt4) {
		this.sliderArt4 = sliderArt4;
	}

	public JLabel getLblPicture() {
		return lblPicture;
	}

	public void setLblPicture(JLabel lblPicture) {
		this.lblPicture = lblPicture;
	}

	public Controller getMando() {
		if (mando == null) {
			mando = new Controller(this);
		}
		return mando;
	}

	public Modelo getModel() {
		return model;
	}

}
