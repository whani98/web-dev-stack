package com.kh._interface;

import com.kh._interface.step1.Bus;
import com.kh._interface.step1.Taxi;
import com.kh._interface.step1.Vehicle;
import com.kh._interface.step2.Audio;
import com.kh._interface.step2.Tv;

public class Application {
	
	/*
	 * Interface Segregation Principle (ISP)
	 * - 인터페이스 분리 원칙
	 * - 필요한 기능만 분리해서 인터페이스로 제공한다.
	 * 
	 * 인터페이스(interface)
	 * - 변수는 무조건 상수
	 * - 메서드는 무조건 추상 메서드
	 * - 객체가 구현해야하는 기능이 있을 때 인터페이스에 추상 메서드로 추가해서 구현하도록
	 * - 인터페이스를 구현하려면 implements 키워드 사용
	 * - 인터페이스를 다중 상속(구현)을 허용한다.
	 * - 추상 클래스보다 더 강한 규칙성, 강제성을 가진다.
	 * 
	 * * 추상 클래스와 인터페이스의 차이점
	 * - 추상 클래스는 abstract 키워드로 클래스가 정의, 변수나 메서드 생성 가능
	 * - 인터페이스는 interface 키워드로 정의, 변수나 메서드 생성 불가
	 * 
	 * extends와 implements
	 * - 클래스 간의 상속 : 자식 클래스 extends 부모 클래스
	 * - 클래스와 인터페이스 간의 구현 : 구현 클래스 implements 인터페이스, 인터페이스..
	 * - 인터페이스 간의 상속 : 인터페이스 extends 인터페이스, 인터페이스..
	 * */

	public static void main(String[] args) {
		Vehicle bus = new Bus();
		Vehicle taxi = new Taxi();
		
		bus.run();
		taxi.turn();
		
		Tv tv = new Tv();
		tv.turnOn();
		tv.turnOff();
		
		Audio audio = new Audio();
		audio.setVolumn(-20);// 최솟값이 0이므로 0으로 출력됨
		audio.setVolumn(55); // 최댓값이 20이므로 20으로 출력됨
		audio.setVolumn(17); // 0과 20 사이의 수 이므로 그대로 출력됨

	}

}
