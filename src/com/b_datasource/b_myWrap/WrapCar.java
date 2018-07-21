package com.b_datasource.b_myWrap;

public class WrapCar implements Car {

	private Car car;
	public WrapCar(Car car){
		this.car = car;
	}
	/**
	 * 增强
	 */
	@Override
	public void runs() {
		System.out.println("add energy");
		System.out.println("fast running");
	}

	/**
	 * 没有增强
	 */
	@Override
	public void breaks() {
		car.breaks();
	}

}
