package Vistas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelMensajeControl extends JPanel {

	private JTextField mensajeDeControl;
	
	/**
	 * Create the panel.
	 */
	public PanelMensajeControl() {
		setLayout(null);
		this.setBorder(new LineBorder(Color.GRAY));
		this.setBounds(0, 335, 600, 43);

		mensajeControl();
	}
	
	private void mensajeControl(){
		mensajeDeControl = new JTextField();
		mensajeDeControl.setEditable(false);
		mensajeDeControl.setText("MENSAJE DE CONTROL");
		mensajeDeControl.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeDeControl.setBounds(6, 6, 588, 26);
		mensajeDeControl.setColumns(10);
		add(mensajeDeControl);
	}

	public JTextField getMensajeDeControl() {
		return mensajeDeControl;
	}
	
}
