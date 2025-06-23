package com.kh.practice2.view;

import java.util.Scanner;

import com.kh.practice2.model.Snack;
import com.kh.practice2controller.SnackController;



// view: HTML, CSS, JavaScript
// 첫번째 프로젝트 : JSP
// 두번째 프로젝트 : React

public class SnackView {
	
	Scanner sc = new Scanner(System.in);
	Snack snackData =  new Snack(); // 자바스크립트에서 객체로 값을 한꺼번에 담아서 보냄
	String kind;
	String name;
	String flavor;
	int numOf;
	int price;
	
	public void input() {
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		snackData.setKind(sc.nextLine());;

		System.out.print("이름 : ");
		snackData.setName(sc.nextLine());;

		System.out.print("맛 : ");
		snackData.setFlavor(sc.nextLine());;

		System.out.print("개수 : ");
		snackData.setNumOf(Integer.parseInt(sc.nextLine()));;

		System.out.print("가격 : ");
		snackData.setPrice(Integer.parseInt(sc.nextLine()));

	}
	
	public void result() {
		SnackController controller = new SnackController();
		System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		System.out.println(controller.confirmData());
	}
}
