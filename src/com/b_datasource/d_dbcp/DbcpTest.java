package com.b_datasource.d_dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DbcpTest {

	@Test
	public void testF1Update() throws Exception{
		//创建连接池
		BasicDataSource bds = new BasicDataSource();
		
		//配置连接信息
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jdbctest");
		bds.setUsername("root");
		bds.setPassword("panli");
		
		//获取连接
		Connection conn = bds.getConnection();
		//编写sql
		String sql = "update category set cname = ? where cid = ?";
		//创建预编译语句执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, "图书类");
		pstmt.setString(2, "c005");
		//执行sql
		int i = pstmt.executeUpdate();
		//处理结果
		if(i == 1){
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
	public void testF2Select() throws Exception{
		 //创建连接池
		BasicDataSource bds = new BasicDataSource();
		
		//设置连接信息
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jdbctest");
		bds.setUsername("root");
		bds.setPassword("panli");
		
		//获取连接
		Connection conn = bds.getConnection();
		//编写sql
		String sql = "select * from category";
		//创建预编译语句执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//设置参数
		
		//执行sql
		ResultSet rs = pstmt.executeQuery();
		//处理结果
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
	public void testF3Add() throws Exception{
		 //创建连接池
		BasicDataSource bds = new BasicDataSource();
		
		//设置连接信息
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jdbctest");
		bds.setUsername("root");
		bds.setPassword("panli");
		
		//获取连接
		Connection conn = bds.getConnection();
		//编写sql
		String sql = "insert into category(cid, cname) values(?, ?)";
		//创建预编译语句执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//设置参数
		pstmt.setString(1, "c007");
		pstmt.setString(2, "家具类");
		//执行sql
		int i = pstmt.executeUpdate();
		//处理结果
		if(i == 1){
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
	public void testF4Del() throws SQLException{
		 //创建连接池
		BasicDataSource bds = new BasicDataSource();
		
		//设置连接信息
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jdbctest");
		bds.setUsername("root");
		bds.setPassword("panli");
		
		//获取连接
		Connection conn = bds.getConnection();
		//编写sql
		String sql ="delete from category where cid = ?";
		//创建预编译语句执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, "c006");
		//执行sql
		int i = pstmt.executeUpdate();
		//处理结果
		if(i == 1){
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
