package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza{

	public BulgogiPizza(int price, String brand) {
		super(price, brand);
	}
	
	@Override
	public void info() {
		String toping = "불고기";
		System.out.println(
				"--------------------------------------------------\n"
				+ brand +"의 " + toping + " 피자 가격은 " + price + "원");
				
	}
	public void topping() {
		System.out.println("토핑은 불고기 포함한다.");
	}
}
