package com.kh._interface.step2;

public class Tv implements RemoteControl, Searchable{ // 두가지의 합집합이 구현이 됨

	@Override
	public void turnOn() {
		
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void search(String url) {
		System.out.println(url + " 검색");
	}

	@Override
	public void setVolumn(int volume) {
	}

}
