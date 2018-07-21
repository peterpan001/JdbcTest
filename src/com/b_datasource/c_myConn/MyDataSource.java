package com.b_datasource.c_myConn;

import java.sql.Connection;
import java.util.LinkedList;

import com.utils.JdbcUtilsConfig;

public class MyDataSource {

	static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	static{
		//初始化时放入3个连接
		for (int i = 0; i < 3; i++) {
			try {
				Connection conn = JdbcUtilsConfig.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 从连接池中获取连接
	 * @return
	 */
	public static Connection getConnection(){
		if(pool.isEmpty()){
			for (int i = 0; i < 2; i++) {
				try {
					Connection conn = JdbcUtilsConfig.getConnection();
					pool.addLast(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("从连接池中获取一个连接");
		Connection conn = pool.removeFirst();
		ConnectionWrap connWrap = new ConnectionWrap(conn, pool);
		return connWrap;
	}
	
	/**
	 * 归还连接
	 * @param conn
	 */
	public static void addBack(Connection conn){
		pool.addLast(conn);
		System.out.println("连接已经归还");
	}
}
