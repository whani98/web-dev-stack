package com.kh.practice1.Application;

import com.kh.practice1.model.UserInfo;

public class Application {

	public static void main(String[] args) {
		// 메인 메서드에서 UserInfo 객체 
		UserInfo user = new UserInfo();
		// changeName()으로 이름 변경 후
		user.changeName("뭉뭉이");
		// printName()을 이용해 출력 : Stirng
		System.out.println(user.printName());
		
	}

}
