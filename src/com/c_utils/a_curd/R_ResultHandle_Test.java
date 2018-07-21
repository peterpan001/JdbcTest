package com.c_utils.a_curd;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.domain.Category;
import com.utils.C3p0UtilsConfig;

public class R_ResultHandle_Test {

	//将查询结果的第一条记录封装成数组,返回
	@Test
	public void arrayHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select * from category";
		
		Object[] query = qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(query));
	}
	
	//将查询结果的每一条记录封装成数组,将每一个数组放入list中返回
	@Test
	public void arrayListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select * from category";
		List<Object[]> list = qr.query(sql, new ArrayListHandler());
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}
	
	
	//将查询结果的第一条记录封装成指定的bean对象,返回
	@Test
	public void beanHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select * from category";
		
		Category bean = qr.query(sql, new BeanHandler<>(Category.class));
		
		System.out.println(bean);
	}
	
	//将查询结果的指定列封装成指定Object，并将其存放在list中返回
	@Test
	public void columnListHandler() throws SQLException{
		QueryRunner qr = new QueryRunner(C3p0UtilsConfig.getDataSource());
		String sql = "select * from category";
		List<Object> list = qr.query(sql, new ColumnListHandler("cname"));
		for (Object obj : list) {
			System.out.println(obj);
		}
		
	}
	//将查询结果的每一条记录封装成指定的bean对象,将每一个bean对象放入list中 返回
	@Test
	public void beanListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select * from category";
		
		List<Category> list = qr.query(sql, new BeanListHandler<>(Category.class));
		
		for (Category bean : list) {
			
			System.out.println(bean);
		}
	}
	
	//将查询结果的第一条记录封装成map,字段名作为key,值为value 返回
	@Test
	public void mapHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select * from category";
		
		Map<String, Object> map = qr.query(sql, new MapHandler());
		System.out.println(map);
	}
	
	//将查询结果的每一条记录封装map集合,将每一个map集合放入list中返回
	@Test
	public void mapListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select * from category";
		
		List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	//针对于聚合函数 例如:count(*) 返回的是一个Long值
	@Test
	public void scalarHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0UtilsConfig.getDataSource());
		
		String sql="select count(*) from category";
		
		Object obj = qr.query(sql, new ScalarHandler());
		System.out.println(obj.getClass().getName());
	}
}
