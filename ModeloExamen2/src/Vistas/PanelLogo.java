package Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelLogo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLogo() {
		setBorder(new LineBorder(Color.GRAY));
		setLayout(null);
		
		etiquetaIcono();
	}
	
	private void etiquetaIcono(){
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelLogo.class.getResource("/Img/Logo.png")));
		label.setBounds(44, 17, 354, 265);
		add(label);
	}
}
