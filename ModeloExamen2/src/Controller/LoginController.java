package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.MySql;
import Modelo.Usuario;

public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	public boolean passVacio(String password){
		if(password.equals("")){
			JOptionPane.showMessageDialog(null, "El campo contraseña no puede estar vacio.");
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean checkLogin(Usuario user, String password){
		if(user.getPassword().equals(password)){
			return true;
		}
		else{
			return false;
		}
	}
}
