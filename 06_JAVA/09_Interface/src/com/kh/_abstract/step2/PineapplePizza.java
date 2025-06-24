package com.kh._abstract.step2;

public class PineapplePizza extends Pizza {

	public PineapplePizza(int price, String brand) {
		super(price, brand);
	}

	@Override
	public void info() {
		String toping = "파인애플";
		System.out.println(
				"--------------------------------------------------\n"
				+ brand +"의 " + toping +" 피자 가격은 " + price + "원");
	}
	public void topping() {
		System.out.println("토핑은 파인애플 포함한다.");
	}
}
