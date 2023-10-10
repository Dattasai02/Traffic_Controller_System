package com.src.annotations;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	
	static Statement st = null;
	static Connection conn = null;
	
	public static Statement getMyStatement() {
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

	public static void CloseMyStatement() {
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static boolean createTable(String name) {
		Class c = null;
		try {
			c = Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] f = c.getDeclaredFields();
		StringBuilder query = new StringBuilder("create table "+c.getSimpleName()+"(");
		for(Field tf:f) {
			
			String name1 = tf.getType().getSimpleName();
			String actname = null;
			if(name1.equals("int"))
				actname = "int";
			else if(name1.equals("boolean"))
				actname = "bit";
			else if(name1.equals("byte"))
				actname = "tinyint";
			else if(name1.equals("short"))
				actname = "smallint";
			else if(name1.equals("long"))
				actname = "bigint";
			else if(name1.equals("float"))
				actname = "real";
			else if(name1.equals("double"))
				actname = "float";
			else if(name1.equals("char"))
				actname = "char";
			else if(name1.equals("String"))
				actname = "varchar(30)";
			else 
				continue;
			query.append(tf.getName()+" "+actname);
			if(tf.isAnnotationPresent(Constraint.class)) {
				query.append(" "+tf.getAnnotation(Constraint.class).constraint());
			}
			query.append(",");
		}
		query.deleteCharAt(query.length()-1);
		query.append(");");
		st=getMyStatement();
		System.out.println(query);
		boolean check = false;
		
		try {
			check = st.execute(query.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CloseMyStatement();
		return check;
		
	}
}
