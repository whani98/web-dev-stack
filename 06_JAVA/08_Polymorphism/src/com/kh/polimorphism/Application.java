package com.kh.polimorphism;

import java.util.Scanner;

import com.kh.polimorphism.controller.EmployeeController;
// FQCN(Full Qualified Class Name) : 클래스 네임이 포함되어 있는 패키지
import com.kh.polimorphism.model.Employee; //  * : 모든 패키지가 선택됨
import com.kh.polimorphism.model.Engineer;
import com.kh.polimorphism.model.Manager;
import com.kh.polimorphism.model.Secretary;

public class Application {

	/*
	 * 다형성(polymorphism) - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력 - 부모 타입을 자식 객체를 생성하는 것
	 * 
	 * Liskov Substitution Principle, LSP - 부모 객체는 자식 객체로 교체해도 문제 없다 - 다형성이 제대로
	 * 설계되었는지 판단하는 기준 중 하나
	 */

	public static void main(String[] args) {

		Employee em = new Employee("문채은", 3000000);
		Employee en = new Engineer("최다인", 3500000, "자바", 300000);
		Employee ma = new Manager("김은진", 4000000, "개발팀");
		Employee se = new Secretary("전영현", 4500000, "문채은");

		System.out.println(em);
		System.out.println(en);
		System.out.println(ma);
		System.out.println(se);
		System.out.println("-----------------------------------------------------------------------");

		// 다형성 + 객체 배열
		Employee[] emp = { em, en, ma, se };

		for (Employee employee : emp) {
			System.out.println(employee);
		}
//		System.out.println("------------------------------------------------------------------------");
//
//		// 이름으로 사람 찾기
		Scanner sc = new Scanner(System.in);
//		System.out.print("이름 검색 : ");
//		String search = sc.nextLine();
//		for (int i = 0; i < emp.length; i++) {
//			if (search.equals(emp[i].getName())) {
//				System.out.println(emp[i]);
//				// 찾은 사람의 연봉은?
//				System.out.println(emp[i].getSalary() * 12);
//			}
//		}
		System.out.println("------------------------------------------------------------------------");
		EmployeeController ec = new EmployeeController();
		System.out.print("이름을 입력해주세요. : ");
		String name = sc.nextLine();
		// 일단 반복문!
		// 이름으로 사람 찾기 -> 이름은 문자열(equals), getName
		Employee findEmployee = ec.findEmployee(emp, name);

		// 찾은 사람의 연봉(getSalary * 12)은?
		// 특정 자식 객체 찾는 방법!
		int annual = ec.getAnnualSalary(findEmployee);
		if(annual != -1) {
		System.out.println(annual);
		} else System.out.println("존재하지 않습니다.");

		// 전체 총 월급 (for문 필요! 각 getSalary 더해나가기)
		System.out.println("------------------------------------------------------------------------");
		System.out.println(ec.totalSalary(emp));

	}

}
