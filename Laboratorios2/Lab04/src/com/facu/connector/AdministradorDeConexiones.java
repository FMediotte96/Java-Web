package com.facu.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AdministradorDeConexiones {

	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String engine = "sqlserver";
	private static String server = "localhost\\SQLEXPRESS01";
	private static String database = "JavaWeb";
	private static String user = "sa";
	private static String password = "123456";
	
	private static String url = "jdbc:" + engine + "://" + server + ";database=" + database;
	
	private static Connection conn = null;

	public AdministradorDeConexiones() {
		
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
