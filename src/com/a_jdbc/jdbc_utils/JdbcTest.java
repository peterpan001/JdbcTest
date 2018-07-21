package com.a_jdbc.jdbc_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.utils.JdbcUtils;

public class JdbcTest {

	@Test
	public void testF1Select(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("cid:" + rs.getString("cid") + " cname:" + rs.getString("cname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.getClose(conn, pstmt, rs);
		}
	}
	
	@Test
	public void testF2Add(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql ="insert into category(cid, cname) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "c005");
			pstmt.setString(2, "生活类");
			int i = pstmt.executeUpdate();
			if(i == 1){
				System.out.println("insert success");
			}else{
				System.out.println("insert fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.getClose(conn, pstmt, null);
		}
	}
	
	@Test
	public void testF3Update(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update category set cname=? where cid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "办公类");
			pstmt.setString(2, "c005");
			int i = pstmt.executeUpdate();
			if(i == 1){
				System.out.println("update success");
			}else{
				System.out.println("update fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.getClose(conn, pstmt, null);
		}
	}
	
	@Test
	public void testF4Del(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql ="delete from category where cid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "c005");
			int i = pstmt.executeUpdate();
			if(i == 1){
				System.out.println("del success");
			}else{
				System.out.println("del fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.getClose(conn, pstmt, null);
		}
	}
}
