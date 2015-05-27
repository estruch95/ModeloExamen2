package Vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import Controller.LoginController;
import Controller.UsuarioController;
import Modelo.ModeloUsuario;
import Modelo.Usuario;


public class PanelLogin extends JPanel {
	private Ventana ventana;
	private JButton btnEntrar;
	private JComboBox<Usuario> comboBoxUsuarios;
	private JPasswordField password;
	private boolean btnEntrarBoolean=false;
	private Usuario usuarioSeleccionado;
	
	private LoginController loginController = new LoginController();
	private UsuarioController usuarioController = new UsuarioController();

	/**
	 * Create the panel.
	 */
	public PanelLogin(Ventana v) {
		this.setBorder(new LineBorder(Color.GRAY));
		this.setLayout(null);
		this.ventana=v;
		
		comboBox();
		jTextField();
		jButton();
	}
	
	private void comboBox(){
		
		comboBoxUsuarios = new JComboBox(usuarioController.loadUsuarios().toArray());
		comboBoxUsuarios.setBounds(22, 26, 142, 27);
		comboBoxUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioSeleccionado = (Usuario) comboBoxUsuarios.getSelectedItem();
			}
		});
		add(comboBoxUsuarios);
		comboBoxUsuarios.setSelectedIndex(0);
	}
	
	private void jTextField(){
		password = new JPasswordField();
		password.setBounds(22, 55, 142, 28);
		add(password);
	}
	
	private void jButton(){
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonEntrar();
			}
		});
		btnEntrar.setBounds(22, 103, 142, 29);
		add(btnEntrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonSalir();
			}
		});
		btnSalir.setBounds(22, 131, 142, 29);
		add(btnSalir);
		
		JButton btnPorReparar = new JButton("Por reparar");
		btnPorReparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonPorReparar();
				}
		});
		btnPorReparar.setBounds(22, 218, 142, 29);
		add(btnPorReparar);
		
		JButton btnReparados = new JButton("Reparados");
		btnReparados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonReparados();
			}
		});
		btnReparados.setBounds(22, 245, 142, 29);
		add(btnReparados);
	}
	
	private void vaciadoJTextField(){
		password.setText("");
	}
	
	private void reloadComboBoxUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(usuarioController.loadUsuarios());
		DefaultComboBoxModel modeloUsuario = new DefaultComboBoxModel(usuarios.toArray());
		comboBoxUsuarios.setModel(modeloUsuario);
		comboBoxUsuarios.repaint();
	}
	
	private void accionBotonEntrar(){
		//Comprobacion de que no exiten vacios en el campo contraseña.
		if(loginController.passVacio(password.getText())==true){
			//Comprobacion de que exite una coincidencia de usuario y contraseña en la bbdd.
			if(loginController.checkLogin(usuarioSeleccionado,password.getText())==true){
				vaciadoJTextField();
				btnEntrarBoolean=true;
				btnEntrar.setEnabled(false);
				comboBoxUsuarios.setEnabled(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
				vaciadoJTextField();
				btnEntrarBoolean=false;
			}
			
		}
	}
	
	private void accionBotonSalir(){
		if(btnEntrarBoolean==false){
			JOptionPane.showMessageDialog(null, "Debes logearte primero amigo!");
		}
		else{
			usuarioController.eliminarUsuario(usuarioSeleccionado);
			btnEntrar.setEnabled(true);
			comboBoxUsuarios.setEnabled(true);
			btnEntrarBoolean=false;
			reloadComboBoxUsuarios();
		}
	}
	
	private void accionBotonPorReparar(){
		if(btnEntrarBoolean==false){
			JOptionPane.showMessageDialog(null, "Debes estar registrado.");
		}
		else{
			CardLayout layout = (CardLayout)ventana.getPanelCentral().getLayout();
			layout.show(ventana.getPanelCentral(), "panelPorReparar");
		}
	}
	
	private void accionBotonReparados(){
		if(btnEntrarBoolean==false){
			JOptionPane.showMessageDialog(null, "Debes estar registrado.");
		}
		else{
			CardLayout layout = (CardLayout) ventana.getPanelCentral().getLayout();
			layout.show(ventana.getPanelCentral(),"panelReparados");
		}
	}
	
	//REVISAR METODO Y AVERIGUAR EL PORQUE NO FUNCIONA CORRECTAMENTE.
	private void cambiaMensajeControl(){
		PanelMensajeControl pmc = new PanelMensajeControl();
		pmc.getMensajeDeControl().setText("ERROR LOGIN");
	}

}
