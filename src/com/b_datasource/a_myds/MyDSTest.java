package com.b_datasource.a_myds;

import java.sql.Connection;

import org.junit.Test;

public class MyDSTest {

	@Test
	public void testMyDS(){
		MyDataSource myDS = new MyDataSource();
		Connection conn = null;
		for (int i = 0; i < 5; i++) {
			conn = myDS.getConnection();
			System.out.println(conn);
			myDS.addBack(conn);
		}
	}
}
