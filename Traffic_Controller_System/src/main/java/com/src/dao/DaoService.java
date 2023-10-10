package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoService {

	private Connection conn = null;
	private Statement st = null;

	public Statement getMyStatement() {
		String Driver_class = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=traffic_controller_system;integratedSecurity=true ;encrypt=true;trustServerCertificate=true;";

		try {
			Class.forName(Driver_class);
			conn = DriverManager.getConnection(url);
			st = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return st;
	}

	public void CloseMyStatement() {
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
