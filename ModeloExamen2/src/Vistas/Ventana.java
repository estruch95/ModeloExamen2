package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Ventana extends JFrame {

	private PanelLogin panelLogin;
	private PanelLogo panelLogo;
	private PanelReparados panelReparados;
	private PanelPorReparar panelPorReparar;
	private PanelMensajeControl panelMensajeControl;
	
	private JPanel panelCentral;

	public Ventana() {
		setTitle("Centro de reparaciones moviles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.getContentPane().setLayout(null);
		
		//DECLARACION DE PANELES
		panelLogin = new PanelLogin(this);
		panelLogo = new PanelLogo();
		panelReparados = new PanelReparados();
		panelPorReparar = new PanelPorReparar();
		panelMensajeControl = new PanelMensajeControl();
		
		panelLoginEstatico();
		panelCentral();
		panelMensajeEstatico();
	}
	
	
	private void panelLoginEstatico(){
		this.getContentPane().add(panelLogin);
		panelLogin.setBounds(0, 0, 190, 330);
	}
	
	private void panelCentral(){
		panelCentral = new JPanel();
		panelCentral.setBounds(202, 0, 398, 330);
		getContentPane().add(panelCentral);
		panelCentral.setLayout(new CardLayout(0, 0));
		
		panelCentral.add(panelLogo, "panelLogo");
		panelCentral.add(panelReparados, "panelReparados");
		panelCentral.add(panelPorReparar, "panelPorReparar");
	}
	
	public JPanel getPanelCentral() {
		return panelCentral;
	}

	private void panelMensajeEstatico(){
		this.getContentPane().add(panelMensajeControl);
		panelMensajeControl.setBounds(0, 335, 600, 43);
	}
}
