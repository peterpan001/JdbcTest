package com.c_utils.a_curd;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import com.utils.C3p0UtilsConfig;

public class CUDTest {

	@Test
	public void testF1Add() throws Exception{
		QueryRunner qr = new QueryRunner(C3p0UtilsConfig.getDataSource());
		//2.编写sql
		String sql="insert into category values(?,?)";
		//3.执行sql
		qr.update(sql, "c201","厨房电器");
	}
	
	@Test
	public void testF2Update()throws Exception{
		QueryRunner qr = new QueryRunner(C3p0UtilsConfig.getDataSource());
		//编写sql
		String sql = "update category set cname=? where cid = ? ";
		//执行sql
		qr.update(sql, "音乐类", "c007");
		
	}
	
	@Test
	public void testF3Del()throws Exception{
		QueryRunner qr = new QueryRunner(C3p0UtilsConfig.getDataSource());
		//编写sql
		String sql = "delete from category where cid = ? ";
		//执行sql
		qr.update(sql, "c009");
	}
}
