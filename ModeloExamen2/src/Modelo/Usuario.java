package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
	
	private int id;
	private String usuario;
	private String password;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return usuario;
	}
}
