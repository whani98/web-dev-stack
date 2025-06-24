package com.kh._abstract.step2;

public class PotatoPizza extends Pizza {

	public PotatoPizza(int price, String brand) {
		super(price, brand);
	}

	public void makePizza() {
		

	}

	@Override
	public void info() {
		
		String toping = "포테이토";
		System.out.println(
				"--------------------------------------------------\n"
				+ brand +"의 " + toping +" 피자 가격은 " + price + "원");
	}
	public void topping() {
		System.out.println("토핑은 포테이토 포함한다.");
	}

}
