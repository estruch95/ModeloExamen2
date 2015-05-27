package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySql {

	private Connection conexion;
	//---------------------------------------
	private String CONTROLADOR_MYSQL="com.mysql.jdbc.Driver";
	private String server="localhost";
	private String bbdd="reparamoviles";
	private String user="root";
	private String pass="";
	//---------------------------------------
	private static MySql instance=null;
	
	public MySql() {
		try {
			Class.forName(CONTROLADOR_MYSQL).newInstance();
			System.out.println("CARGA CORRECTA DEL CONTROLADOR JDBC");
		} catch (Exception errorCargaControlador) {
			errorCargaControlador.printStackTrace();
			System.out.println("ERROR EN LA CARGA DEL CONTROLADOR JDBC");
		}
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://"+server+"/"+bbdd+"?"+"user="+user+"&password="+pass);
			System.out.println("CONEXION REALIZADA CON EXITO");
		} catch (SQLException errorConexionBBDD) {
			errorConexionBBDD.printStackTrace();
			System.out.println("ERROR EN LA CONEXION DE LA BBDD");
		}
	}

	public static MySql getInstance() {
		if(instance==null) {
			instance=new MySql();
		}
		return instance;
	}
		

		//Con este metodo hago los selects
	public ResultSet query(String query){
		
		
		Statement st;
		ResultSet rs = null;

		try {
			st = conexion.createStatement();
			try{
				rs = st.executeQuery(query);
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		} catch (SQLException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return rs;	
										
	}
	
	//Con este metodo vamos a hacer los inserts, update y deletes.
	public int modifyQuery(String update){
		Statement stmt;
		int rs = 0;
		try{
		stmt = conexion.createStatement();		
			try{
				rs = stmt.executeUpdate(update);
			}catch (SQLException e){
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}
