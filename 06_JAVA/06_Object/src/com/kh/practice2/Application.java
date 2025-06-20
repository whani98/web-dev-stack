package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.model.Snack;
import com.kh.practice2controller.SnackController;

public class Application {

	public static void main(String[] args) {
		Snack s = new Snack();
		Scanner sc = new Scanner(System.in);
		SnackController controller = new SnackController();

		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		s.setKind(sc.nextLine());
		System.out.print("이름 : ");
		s.setName(sc.nextLine());
		System.out.print("맛 : ");
		s.setFlavor(sc.nextLine());
		System.out.print("개수 : ");
		s.setNumOf(sc.nextInt());
		System.out.print("가격 : ");
		s.setPrice(sc.nextInt());

		System.out.println(controller.saveData(s.getKind(), s.getName(), s.getFlavor(), s.getNumOf(), s.getPrice()));
		System.out.println(controller.confirmData());

	}

}
