package com.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {

	static final String DRIVERCLASS;
	static final String JDBCURL;
	static final String USER;
	static final String PASSWORD;
	static {
		DRIVERCLASS = "com.mysql.jdbc.Driver";
		JDBCURL = "jdbc:mysql:///jdbctest";
		USER = "root";
		PASSWORD = "panli";
	}
	
	public static Connection getConnection() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(DRIVERCLASS);
		cpds.setJdbcUrl(JDBCURL);
		cpds.setUser(USER);
		cpds.setPassword(PASSWORD);
		return cpds.getConnection();
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
