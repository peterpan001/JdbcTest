package com.b_datasource.b_myWrap;

import org.junit.Test;

public class WrapTest {

	/**
	 * 传统的
	 */
	@Test
	public void testQQ(){
		QQ qq = new QQ();
		qq.runs();
		qq.breaks();
	}
	
	/**
	 * 装饰着模式
	 */
	@Test
	public void testQQ1(){
		QQ qq = new QQ();
		WrapCar wrap = new WrapCar(qq);
		wrap.runs();
		wrap.breaks();
	}
}
