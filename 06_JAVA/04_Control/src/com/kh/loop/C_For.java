package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class C_For {
	Scanner sc = new Scanner(System.in);
	
	/*
	 * for 문
	 * 
	 * for (초기식; 조건식; 증감식) {
	 *       실행 코드
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문
	 * - 초기식 : 반복문이 수행될 때, 단 한 번만 실행, 반복문 안에서 사용할 변수를 선언하고, 초기값 대입
	 * - 조건식 : 결과가 true이면 실행 코드를 실행, false이면 실행하지 않고 반복문을 빠져나감
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	 * */
	
	// 1 ~ 5 출력
	public void method1() {
		for (int i = 1; i <= 5; i++) {System.out.println(i);}
	}
	
	// 5 ~ 1
	public void method2() {
		for (int i = 5; i >= 1; i--) {System.out.println(i);}
	}
	
	// 1~10  사이 홀수
	public void method3() {
		// 방법 1
		for (int i = 1; i <= 10; i += 2) {System.out.println(i);}
		// 방법 2
		for (int i = 1; i % 2 != 0 && i <= 10; i++) {System.out.println(i);}
		// 방법 3
		for (int i = 1; i <= 10; i++) { if (i % 2 == 0) continue; System.out.println(i);}
	}
	/*continue 문 
	 * - continue문은 반복문 안에서 사용
	 * - 반복문 안에서 continue를 만나면 "현재 구문" 종료
	 * - 반복문을 빠져나가는 건 아님!*/
	
	// 1~10 까지 합계
	public void method4() {
		int sum = 0;
		
		for (int i = 1; i <= 10; i++){
			sum += i; }
		System.out.println(sum);
	} 
	
	
	// 1부터 사용자가 입력한 수까지의 합계
	public void method5() {
		int sum = 0;
		System.out.println("수 입력 > ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			sum+=i;
		};
		System.out.println(sum);
		
	}
	
	// 1부터 랜덤값까지의 합계
	public void method6() {
		double random = (int) (Math.random() * 9 + 2); // (0.0 <= random < 1.0)
		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2; // 2 ~ 10까지
		int random4 = random2.nextInt(2, 11); // 2 ~ 10까지
		
		int sum = 0;
		for (int i = 1; i <= random; i++) {
			sum+=i;
		};
		System.out.println((int) random + ", " + sum);
			
	}
	
	/*
	 * 사용자한테 입력받은 문자열을 세로로 출력
	 * 사용자 입력 > hello
	 * h
	 * e
	 * l
	 * l
	 * o
	 * */
	public void method7() {
		System.out.print("문자열 입력 > ");
		String str =  sc.nextLine();
		for (int i = 0; i < str.length(); i++)
		System.out.println(str.charAt(i));
		
		
		/*
		 * 향상된 for문
		 * for(데이터타입 변수 : 배열) {
		 *     변수 : 배열의 값을 하나씩 가지고 온다.
		 * }
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열
		 * - toCharArray : 모든 문자가 들어있는 char[] 형식의 데이터 반환
		 * - charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환
		 * */
		char[] arr = str.toCharArray();
		for (char ch : str.toCharArray()) {
			System.out.println(ch);
		}
	}
	// 중첩 for문
	/*
	 * 
	 * *****
	 * *****
	 * *****
	 * *****
	 * */
	public void method8() {
		for (int j = 1; j <= 4; j++) {
		for (int i = 1; i<= 5; i++) 
		{System.out.print("*");}
		System.out.println();}
	}
	
	/*
	 * 1****
	 * *2***
	 * **3**
	 * ***4*
	 * ****5
	 * */
	public void method9() {
		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= 5; i++) 
			{System.out.print(i == j ? i : "*");}
			System.out.println();}
		
		
	}
	/*
	 * *     i=0 (0,0)          (0,4)
	 * **    i=1 
	 * ***   i=2 
	 * ****  i=3 (4,0)          (4,4)
	 * ***** i=4 j=0 j=1 j=2 j=3 j=4
	 * */
	public void method10() {
		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= 5; i++) {
			System.out.print(i <= j ? "*" : " ");
			}
			System.out.println();
			}
	}
	
	/*
	 *     *
	 *    **
	 *   ***
	 *  ****
	 * *****
	 * */
	public void method11() {
		for (int j = 1; j <= 5; j++) {
			for (int i = 4; i >= 0; i--) {
			System.out.print(i < j ? "*" : " ");
			}
			System.out.println();
			}
	}
	
	public static void main(String[] args) {
		C_For c = new C_For();
		c.method10();
		c.method11();
		

	}

}
