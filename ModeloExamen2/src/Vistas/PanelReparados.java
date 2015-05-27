package Vistas;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Modelo.ModeloMovil;



public class PanelReparados extends JPanel {
	
	private JTable tablaReparaciones;
	private JTextField textFieldDescripcion;
	
	/**
	 * Create the panel.
	 */
	public PanelReparados() {
		setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		jLabel();
		jTextField();
		jTable();
	}
	
	private void jLabel(){
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(25, 225, 105, 16);
		add(lblDescripcion);
	}
	
	private void jTextField(){
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(22, 253, 303, 28);
		add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
	}
	
	private void jTable(){
		/*
		//DATOS TABLA
		String cabeceras[]={"Tecnico","Tipo movil","Fecha reparacion"};
		String datos[][]={{"Alvaro","Samsung","fecha"},
							{"Ivan","Iphone 5s","fecha"},
							{"Nico","Xiaomi","fecha"},
							{"Pablo","LG","fecha"},
							{"Pepe","LG","fecha"},
							{"Andres","APPLE","fecha"},
							{"Lucia","BQ","fecha"},
							{"Barbara","Sony","fecha"},
		};
		
		modeloDatos = new DefaultTableModel(datos,cabeceras);
		tablaReparacionesMoviles = new JTable(modeloDatos);
		
		tablaReparacionesMoviles.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaReparacionesMoviles.setGridColor(Color.GRAY);
		tablaReparacionesMoviles.setBounds(25, 28, 334, 100);
		
		JScrollPane scrollPane = new JScrollPane(tablaReparacionesMoviles);
		scrollPane.setViewportView(tablaReparacionesMoviles);
		add(scrollPane);
		
		add(tablaReparacionesMoviles);
		*/
		
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
