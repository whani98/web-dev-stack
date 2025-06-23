package com.kh.overridng;

import java.util.Scanner;

import com.kh.inheritance.model.parent.Product;
import com.kh.overridng.model.Customer;
import com.kh.overridng.model.VipCustomer;

public class Application {
	
	/*
	 * SOLID의 O
	 * Open/Closed Principle (개방-폐쇄 원칙)
	 * -  기존 코드를 변경하지 않고 확장 가능하게
	 * 
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이름
		System.out.print("이름 : ");
		String name = sc.nextLine();
		// 일반 회원 vs VIP
		System.out.print("일반 회원 or VIP 둘 중 하나 선택 : ");
		String grade = sc.nextLine();
		// 가격
		System.out.print("가격 : ");
		int price =  sc.nextInt();
		
		Customer customer5 = null;
		if(grade.equals("VIP")) {
			customer5 = new VipCustomer(name);
			
		} else {
			customer5 = new Customer(name);
		}
		customer5.calc(price);
		System.out.println(customer5);
		
		Product product = new Product();
		product.setBrand("LG");
		customer5.setProduct(product);
		System.out.println(customer5.getProduct().getBrand());;		
		
//		int price = 100000;
		
		Customer customer1 = new Customer("서지은");
		customer1.calc(price);
		System.out.println(customer1); // 주소값이 뜸
		
		VipCustomer customer2 =  new VipCustomer("김은진");
		customer2.calc(price);
		System.out.println(customer2);
		
		// 동명이인은 없다고 가정
		Customer customer3 = new Customer("서지은");
		VipCustomer customer4 = new VipCustomer("김은진");
		System.out.println(customer1.getName().equals(customer3.getName())); //true
		System.out.println(customer2.getName().equals(customer4.getName())); //true
		
		System.out.println(customer1.equals(customer3)); 
		System.out.println(customer2.equals(customer4));
		
		// 100000
		// ~~님의 등급은 ~~이며, 지불해야하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다.
		
//		System.out.println(customer1.getName() + "님의 등급은 " 
//		         + customer1.getGrade() + "이며, 지불해야하는 금액은 " 
//				 + price + "원이며, 적립된 포인트는 " 
//		         + (price * customer1.getBonusRatio()) + "점입니다.");
		// 또는 Customer의 toString에 입력 가능
		
//		System.out.println(customer2.getName() + "님의 등급은 " 
//		         + customer2.getGrade() + "이며, 지불해야하는 금액은 " 
//				 + price * customer2.getSaleRatio() + "원이며, 적립된 포인트는 " 
//		         + (price * customer2.getBonusRatio()) + "점입니다.");
		// 또는 VipCustomer의 toString에 입력 가능
		
		}


}
