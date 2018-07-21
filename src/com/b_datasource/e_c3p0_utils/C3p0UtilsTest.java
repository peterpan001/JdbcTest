package com.b_datasource.e_c3p0_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.utils.C3p0Utils;

public class C3p0UtilsTest {

	@Test
	public void testF1Select() throws Exception{
		
		Connection conn = C3p0Utils.getConnection();
		String sql ="select * from category";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println("cid:" + rs.getString("cid") + " cname:" + rs.getString("cname"));
		}
		//释放资源
		C3p0Utils.getClose(conn, pstmt, rs);
	}
	
	@Test
	public void testF2Update() throws Exception{
		Connection conn = C3p0Utils.getConnection();
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
		C3p0Utils.getClose(conn, pstmt, null);
	}
	
	@Test
	public void testF3Add() throws Exception{
		Connection conn = C3p0Utils.getConnection();
		String sql ="insert into category values(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "c008");
		pstmt.setString(2, "图书类");
		int i = pstmt.executeUpdate();
		if(i==1){
			System.out.println("add success");
		}else{
			System.out.println("add fail");
		}
		//释放资源
		C3p0Utils.getClose(conn, pstmt, null);
	}
	
	
	@Test
	public void testF4Del() throws Exception{
		Connection conn = C3p0Utils.getConnection();
		String sql ="delete from category where cid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "c008");
		int i = pstmt.executeUpdate();
		if(i==1){
			System.out.println("del success");
		}else{
			System.out.println("del fail");
		}
		//释放资源
		C3p0Utils.getClose(conn, pstmt, null);
	}
}
