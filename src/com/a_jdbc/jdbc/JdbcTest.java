package com.a_jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Driver;
/**
 * mysql java.sql.SQLException: Unknown system variable 'language'
 * 
 * 一般为数据库版本过低，或者jar包版本过高
 * @author Peter
 *
 */
public class JdbcTest {
	
	@Test
	public void testF1(){
		System.out.println("hello Jdbc");
	}
	/**
	 * 使用原生JDBC增加数据
	 * @throws Exception
	 */
	@Test
	public void testF2Add() throws Exception{
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "panli");
		//编写sql
		String sql = " insert into category(cid, cname) values(?, ?) ";
		//创建预编译语句的执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, "c005");
		pstmt.setString(2, "厨具类");
		//执行sql
		int i = pstmt.executeUpdate();
		//处理结果
		if(i == 1){
			System.out.println("插入成功！");
		}else{
			System.out.println("插入失败！");
		}
		//释放资源
		if(pstmt!=null){
			pstmt.close();
			pstmt = null;
		}
		if(conn != null){
			conn.close();
			conn = null;
		}
	}

	@Test
	public void testF3Select()throws Exception{
		
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "panli");
		//编写sql
		String sql = "select * from category";
		//创建预编译语句的执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		
		//执行sql
		ResultSet rs = pstmt.executeQuery();
		//结果处理
		while(rs.next()){
			System.out.println(rs.getString("cid"));
			System.out.println(rs.getString("cname"));
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
	public void testF4Update()throws Exception{
		
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "panli");
		//编写sql
		String sql = "update category set cname = ? where cid = ?";
		//创建预编译语句的执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, "熟食类");
		pstmt.setString(2, "c004");
		//执行sql
		int i = pstmt.executeUpdate();
		//处理结果集
		if(i == 1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
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
	public void testF5Del()throws Exception{
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "panli");
		//编写sql
		String sql = "delete from category where cid = ? ";
		//创建预编译语句的执行者
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, "c005");
		//执行sql
		int i = pstmt.executeUpdate();
		//处理结果
		if(i == 1){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
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
