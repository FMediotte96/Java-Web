package com.facu.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.facu.connector.AdministradorDeConexiones;

public class TestConnector {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = AdministradorDeConexiones.getConnection();
		
		String sql = "insert into users (username,email,password) " + 
				"values('fedeinsua','fede@gmail.com','123')";
		conn.createStatement().execute(sql);
		conn.close();
	}

}
