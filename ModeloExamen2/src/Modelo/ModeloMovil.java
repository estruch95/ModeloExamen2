package Modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloMovil extends AbstractTableModel{
	
	private String cabeceras[]={"Tecnico","Tipo Movil","Fecha reparacion"};
	
	public ModeloMovil() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Movil> load(){
		MySql conexion = MySql.getInstance();
		ResultSet rs = conexion.query("SELECT * FROM moviles;");
		
		ArrayList<Movil> moviles = new ArrayList<Movil>();
		try{
			while(rs.next()){
				Movil movil = new Movil();
				movil.setId((int)rs.getObject("id"));
				movil.setTecnico((String)rs.getObject("tecnico"));
				movil.setMovil((String)rs.getObject("movil"));
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
				String fechaReparacionString = formatter.format(rs.getObject("fechaReparado")); 
				movil.setFechaReparacion(fechaReparacionString);
				
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy"); 
				String fechaReparacionMaxString = formatter1.format(rs.getObject("fechaMax")); 
				movil.setFechaReparacionMaxima(fechaReparacionMaxString);
				
				movil.setDescripcion((String)rs.getObject("descripcion"));
				movil.setNumReparaciones((int)rs.getObject("reparados"));
				moviles.add(movil);
			}
		}
		catch(SQLException errorLoadMovil){
			errorLoadMovil.printStackTrace();
			System.out.println("ERROR EN LOAD MOVIL");
		}
		return moviles;
	}
	
	public void save(){
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.load().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object value = "??";
		Movil movil = this.load().get(rowIndex);

		switch (columnIndex) {
		case 0:
			value = movil.getTecnico();
			break;
		case 1:
			value = movil.getMovil();
			break;
		case 2:
			value = movil.getFechaReparacion();
			break;
		case 3:
			value = movil.getFechaReparacionMaxima();
			break;
		}

		return value;
	}
	
	@Override
	public String getColumnName(int columnIndex) {

		return cabeceras[columnIndex];
	}

}
