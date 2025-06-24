package com.kh._interface.step2;

public interface RemoteControl extends Volume, Searchable { 
	// 인터페이스끼리는 다중 상속(extends) 가능, implement 불가능
	
	void turnOn();
	void turnOff();

}
