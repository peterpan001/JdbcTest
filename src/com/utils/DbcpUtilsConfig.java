package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpUtilsConfig {

	public static Connection getConnection() throws Exception{
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/dbcp.properties"));
		DataSource ds = new BasicDataSourceFactory().createDataSource(prop);
		Connection conn = ds.getConnection();
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
