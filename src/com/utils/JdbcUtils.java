package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	
	static final String CLASSNAME;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	
	static{
		CLASSNAME = "com.mysql.jdbc.Driver";
		URL = "jdbc:mysql://localhost:3306/jdbctest";
		USER = "root";
		PASSWORD = "panli";
	}
	
	static{
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//建立连接
	public static Connection getConnection()throws Exception{
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	public static void getClose(Connection conn, Statement stmt, ResultSet rs){
		getCloseRs(rs);
		getCloseStat(stmt);
		getCloseConn(conn);
	}
	
	public static void getCloseRs(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	public static void getCloseStat(Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	
	public static void getCloseConn(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
