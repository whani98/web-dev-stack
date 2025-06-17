package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문
	 * 
	 * switch(조건식) {
	 *     case 값1 : 조건식의 결과가 값1과 같은 경우
	 *          break;
	 *     case 값2 : 조건식의 결과가 값2과 같은 경우
	 *          break;
	 *     case 값3 : 조건식의 결과가 값3과 같은 경우
	 *          break;
	 *     default : 조건식의 결과가 일치하는 case 문이 없을 때 실행
	 * }
	 * 
	 * -  case 문의 수는 제한이 없다.
	 * - 조건식의 결과는 정수, 문자, 문자열이어야 한다.
	 * - 조건문을 빠져나가려면 break가 필요하다.
	 * - default 문은 생략가능하다.
	 * */
	
	/*
	 * 문제 1
	 * 숫자를 입력받아
	 * 1일 경우 "빨간색 입니다."
	 * 2일 경우 "파란색 입니다"
	 * 3일 경우 "초록색 입니다"
	 * 잘못입력했을 경우 "잘못입력했습니다."
	 * */
	public void method1() {
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		switch (num){
		case 1 : System.out.println("빨간색 입니다.");
		   break;
		case 2 : System.out.println("파란색 입니다.");
		   break;
		case 3 : System.out.println("초록색 입니다.");
		   break;
		default : System.out.println("잘못입력했습니다.");
		}
		
	}
	/*
	 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력 (그 외에는 "사람이 아닙니다.")
	 * 주민번호 입력 000000-0000000
	 * 남자
	 * */
	
	public void method2() {
		System.out.print("주민번호 입력 > ");
		String no = sc.nextLine();
		char noChar = no.charAt(7);
		String noStr = no.substring(7, 8); // 7번째부터 8번째 까지 찾음
		
		//System.out.println(noChar);
		//System.out.println(noStr); <- 얘를 쓸 경우 쌍따옴표
		switch (Integer.parseInt(noStr)) {
		   case 1 : 
		   case 3 :    
			   System.out.print("남자");
		        break;
		   case 2 : 
		   case 4 :
		       System.out.print("여자");
		        break;
		   default : System.out.println("사람이 아닙니다.");
		}
		   /* 
		   최신버전
		   switch (Integer.parseInt(noStr)) {
		   case 1 ,3 :    
			   System.out.print("남자");
		        break;
		   case 2 ,4 :
		       System.out.print("여자");
		        break;
		   default : System.out.println("사람이 아닙니다.")
		   */
		}
		


	public static void main(String[] args) {
		B_Switch b = new B_Switch();
		b.method2();

	}

}
