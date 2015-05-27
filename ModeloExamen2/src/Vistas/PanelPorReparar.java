package Vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Modelo.ModeloMovil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPorReparar extends JPanel {
	
	private JTable tablaReparaciones;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelPorReparar() {
		setLayout(null);
		this.setBounds(0, 0, 398, 330);
		
		jLabel();
		jTextField();
		jButton();
		jTable();
	}
	
	private void jLabel(){
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(25, 225, 105, 16);
		add(lblDescripcion);
	}
	
	private void jTextField(){
		textField = new JTextField();
		textField.setBounds(22, 253, 303, 28);
		add(textField);
		textField.setColumns(10);
	}
	
	private void jButton(){
		JButton btnReparar = new JButton("Reparar");
		btnReparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReparar.setBounds(21, 295, 119, 29);
		add(btnReparar);
	}
	
	private void jTable(){
		tablaReparaciones = new JTable();
		tablaReparaciones.setGridColor(Color.GRAY);
		tablaReparaciones.setFont(new Font("Georgia", Font.BOLD, 11));
		tablaReparaciones.setBorder(new LineBorder(Color.GRAY));
		tablaReparaciones.setModel(new ModeloMovil());
		tablaReparaciones.getColumnModel().getColumn(0).setResizable(false);
		tablaReparaciones.getColumnModel().getColumn(1).setResizable(false);
		tablaReparaciones.getColumnModel().getColumn(2).setResizable(false);
		tablaReparaciones.setBounds(25, 28, 334, 100);
		tablaReparaciones.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
		JScrollPane scrollPane = new JScrollPane(tablaReparaciones);
		scrollPane.setViewportBorder(new LineBorder(Color.GRAY, 2));
		scrollPane.setBounds(25, 28, 335, 185);
		add(scrollPane);
		alineacionCentradaCeldas();
	}
	
	public void alineacionCentradaCeldas(){
		DefaultTableCellRenderer AlinearTablaReparaciones = new DefaultTableCellRenderer();
		AlinearTablaReparaciones.setHorizontalAlignment(SwingConstants.CENTER);//ALINEACION CENTRADA
		tablaReparaciones.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(AlinearTablaReparaciones);
		tablaReparaciones.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(AlinearTablaReparaciones);
		tablaReparaciones.getTableHeader().getColumnModel().getColumn(2).setCellRenderer(AlinearTablaReparaciones);
	}
}
