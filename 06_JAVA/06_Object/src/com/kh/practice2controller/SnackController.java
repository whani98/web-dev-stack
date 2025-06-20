package com.kh.practice2controller;

import com.kh.practice2.model.Snack;

public class SnackController {
	Snack s = new Snack();

	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		// 구현이 끝나고 - setter
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다.";
	}

	public String confirmData() {
		return s.getKind() + "(" + s.getName() + " - " + s.getFlavor() + ") " 
	         + s.getNumOf() + "개 " + s.getPrice() + "원";
	}
}
