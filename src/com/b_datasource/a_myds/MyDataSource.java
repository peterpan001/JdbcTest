package com.b_datasource.a_myds;

import java.sql.Connection;
import java.util.LinkedList;

import com.utils.JdbcUtils;

/**
 * 自定义简易连接池
 * @author Peter
 *
 */
public class MyDataSource {

	
	static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	//初始化
	static {
		for (int i = 0; i < 3; i++) {
			try {
				Connection conn = JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取连接
	 * @return 返回连接
	 */
	public static Connection getConnection(){	
		if(pool.isEmpty()){
			//如果连接池用完，将再创建两个
			System.out.println("连接池新增加了两个连接");
			for (int i = 0; i < 2; i++) {
				try {
					Connection conn = JdbcUtils.getConnection();
					pool.addLast(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("从连接池中获取一个连接");
		return pool.removeFirst();
	}
	
	/**
	 * 归还连接
	 * @param conn 连接
	 */
	public static void addBack(Connection conn){
		//将连接放入末尾
		pool.addLast(conn);
		System.out.println("连接已经归还");
	}
}
