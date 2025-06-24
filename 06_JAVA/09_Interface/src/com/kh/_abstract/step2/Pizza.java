package com.kh._abstract.step2;

public abstract class Pizza {
	
	protected int price;
	protected String brand;

	public Pizza(int price, String brand) {
		this.price = price;
		this.brand = brand;
	}
	// 여기서부터는 자유롭게!
	
	
	public abstract void info();
	public abstract void topping();
	
	
}
