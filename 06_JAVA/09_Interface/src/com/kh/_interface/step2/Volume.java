package com.kh._interface.step2;

public interface Volume {
	
	//인터페이스에서 멤버 변수는 무조건 상수! public static final이 안써있는건 생략되어 있는 것과 같다.(항상 적용이 된다는 의미)
	public static final int MIN_VOLUME = 0; 
	int MAX_VOLUME = 20;
	
	void setVolumn(int volume);

}
