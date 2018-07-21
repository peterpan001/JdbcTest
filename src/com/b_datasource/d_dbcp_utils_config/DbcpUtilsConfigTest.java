package com.b_datasource.d_dbcp_utils_config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.utils.DbcpUtilsConfig;

public class DbcpUtilsConfigTest {

	@Test
	public void testF1Update(){
		
		//获取连接
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbcpUtilsConfig.getConnection();
			//编写sql
			String sql = "update category set cname = ? where cid = ?";
			//创建预编译语句执行者
			pstmt = conn.prepareStatement(sql);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
			DbcpUtilsConfig.getClose(conn, pstmt, null);
		}

	}
	
	@Test
	public void testF2Select(){
		
		//获取连接
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbcpUtilsConfig.getConnection();
			//编写sql
			String sql = "select * from category";
			//创建预编译语句执行者
			pstmt = conn.prepareStatement(sql);
			
			//设置参数
			
			//执行sql
			ResultSet rs = pstmt.executeQuery();
			//处理结果
			while(rs.next()){
				System.out.println("cid:" + rs.getString("cid") + " cname:" + rs.getString("cname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
			DbcpUtilsConfig.getClose(conn, pstmt, null);
		}
	}
	
	@Test
	public void testF3Add(){
		
		//获取连接
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbcpUtilsConfig.getConnection();
			//编写sql
			String sql = "insert into category(cid, cname) values(?, ?)";
			//创建预编译语句执行者
			pstmt = conn.prepareStatement(sql);
			
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
			DbcpUtilsConfig.getClose(conn, pstmt, null);
		}
	}
	
	@Test
	public void testF4Del(){
		
		//获取连接
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbcpUtilsConfig.getConnection();
			//编写sql
			String sql ="delete from category where cid = ?";
			//创建预编译语句执行者
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, "c007");
			//执行sql
			int i = pstmt.executeUpdate();
			//处理结果
			if(i == 1){
				System.out.println("del success");
			}else{
				System.out.println("del fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//释放资源
			DbcpUtilsConfig.getClose(conn, pstmt, null);
		}
		
	}
}
