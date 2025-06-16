package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();
		v.method3();
		v.method4();
		v.method5();
		v.method6();
		v.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int adult = 10000;
		int youth = 7000;
		System.out.printf("총 지불 금액은 %d원입니다.", adult * 2 + youth * 3);

	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		// 코드 적어주세요!
		System.out.printf("\n x=%d \n y=%d \n x=%d  \n", y, z, x);
		
		/*
		 * 또는
		 *System.out.println("x=", y);
		 *System.out.println("y=", z);
		 *System.out.println("z=", x);
		 * */

	}
	
	

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		int iNum1 = 23;
		int iNum2 = 7;
		System.out.printf("%d과 %d의 합은 %d, 차는 %d, 곱은 %d, 나누기한 몫은 %d \n", iNum1, iNum2, iNum1+iNum2, iNum1-iNum2, iNum1*iNum2, iNum1/iNum2);
	}

	/*
	 * 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		double width = 13.5;
		double height = 41.7;
		System.out.println("(사각형의 면적)=" + width*height);
		System.out.println("(사각형의 둘레)=" + 2*(width+height));

	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		String apple = "apple";
		int first = apple.length(); //5
		System.out.printf("첫번째 문자 : %.1s \n", apple);
		System.out.printf("두번째 문자 : %.2s \n", apple);
		System.out.printf("마지막 문자 : %.5s \n", apple);
// 잘 모르겠어요 ㅠ
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		int A = 'A';
		System.out.println("A unicode : " + A); //65
		int B = 'B';
		System.out.println("B unicode : " + B); //66

	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		int kor =  75;
		int eng =  63;
		int mth =  80;
		int total = kor+eng+mth;
		int avg = total/3;
				
		System.out.printf("총점은 %d, 평균은 %d", total, avg);

	}

}