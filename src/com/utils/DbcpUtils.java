package com.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DbcpUtils {

	static final String DRIVERCLASSNAME;
	static final String URL;
	static final String USERNAME;
	static final String PASSWORD;
	
	static {
		DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
		URL="jdbc:mysql://localhost:3306/jdbctest";
		USERNAME="root";
		PASSWORD="panli";
	}
	
	public static Connection getConnection() throws Exception{
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(DRIVERCLASSNAME);
		bds.setUrl(URL);
		bds.setUsername(USERNAME);
		bds.setPassword(PASSWORD);
		Connection conn = bds.getConnection();
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
