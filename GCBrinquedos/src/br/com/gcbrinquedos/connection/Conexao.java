package br.com.gcbrinquedos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/dbgcbrinquedos";
		//	String url ="jdbc:mysql://192.168.0.100:3306/dbgcbrinquedo";
			String user ="root";
			String password="";
			
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;

	}
}
