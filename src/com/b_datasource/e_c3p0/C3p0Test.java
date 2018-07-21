package com.b_datasource.e_c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Test {

	@Test
	public void testF1Select() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///jdbctest");
		cpds.setUser("root");
		cpds.setPassword("panli");
		Connection conn = cpds.getConnection();
		String sql ="select * from category";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println("cid:" + rs.getString("cid") + " cname:" + rs.getString("cname"));
		}
		//释放资源
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pstmt!=null){
			pstmt.close();
			pstmt = null;
		}
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
	
	@Test
	public void testF2Update() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///jdbctest");
		cpds.setUser("root");
		cpds.setPassword("panli");
		Connection conn = cpds.getConnection();
		String sql ="update category set cname=? where cid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "废弃物");
		pstmt.setString(2, "c006");
		int i = pstmt.executeUpdate();
		if(i==1){
			System.out.println("update success");
		}else{
			System.out.println("update fail");
		}
		//释放资源
		
		if(pstmt!=null){
			pstmt.close();
			pstmt = null;
		}
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
	
	@Test
	public void testF3Add() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///jdbctest");
		cpds.setUser("root");
		cpds.setPassword("panli");
		Connection conn = cpds.getConnection();
		String sql ="insert into category values(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "c007");
		pstmt.setString(2, "图书类");
		int i = pstmt.executeUpdate();
		if(i==1){
			System.out.println("add success");
		}else{
			System.out.println("add fail");
		}
		//释放资源
		
		if(pstmt!=null){
			pstmt.close();
			pstmt = null;
		}
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
	
	
	@Test
	public void testF4Del() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///jdbctest");
		cpds.setUser("root");
		cpds.setPassword("panli");
		Connection conn = cpds.getConnection();
		String sql ="delete from category where cid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "007");
		int i = pstmt.executeUpdate();
		if(i==1){
			System.out.println("del success");
		}else{
			System.out.println("del fail");
		}
		//释放资源
		
		if(pstmt!=null){
			pstmt.close();
			pstmt = null;
		}
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
}
