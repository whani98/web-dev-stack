package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class D_While {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 *      조건이 true일 경우 계속 실행
	 * }
	 * */
	
	// 1~5 출력
	public void method1() {
		int i = 1;
		while (i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	/*
	 * 무한루프 & break문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 * */
	public void method2() {
		while(true) {
			System.out.print("숫자입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			// 숫자가 0인 경우 중지!
			if (num == 0) break;
		}
	}
	
	/*
	 * do {
	 *     실행코드
	 * } while(조건식);
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * */
	
	public void method3() {
		int number = 1;
		 while(number==0) {
			 System.out.println("while");
		 }
		 
		 do {
			 System.out.println("do-while");
		 } while(number==0);
	}
	/*
	 * 숫자 맞히기 게임
	 * 1과 100 사이의 값 중 정답을 저희가 정하고
	 * 컴퓨터(random)가 맞히도록! 몇 번만에 끝내는지 출력!
	 * 해당 숫자보다 정답이 높으면 up! 아니면 down!
	 * */
	public void method4() {
		int answer = 30;
		int max = 100; 
		int min = 1;
		int count = 0;
		while (true) {
			++count;
			int random = (int) (Math.random() * (max-min +1) + min);
			if (answer > random)
				{System.out.println(random + ", Up!");
				min = random + 1;
				}
			else if (answer < random){
				System.out.println(random + ", down!");
				max = random - 1;
				}
			else {
				System.out.println(random + ", 정답! " + count + "회 만에 맞혔습니다!"); break;
			}
			
		}
	}
	/*
	 * 숫자 맞히기 게임2
	 * 
	 * 컴퓨터(random)1과 100 사이의 값 중 
	 * 정답을 저희가 몇 번만에 끝내는지 출력!
	 * 해당 숫자보다 정답이 높으면 up! 아니면 down!
	 * */
	public void method5() {
		int random = (int) (Math.random() * 100 + 1);
		int count = 0;
		while (true) {
			++count;
			System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
			
			if (num < random)
				{System.out.println("Up!");
				}
			else if (num > random){
				System.out.println("down!");
				}
			else {
				System.out.println("정답! " + count + "회 만에 맞혔습니다!"); break;
			}
			
		}
	}
	
	/*
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택 > 1
	 * 예금액 > 10000
	 * ----------------------------------
	 *  1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 *  선택 > 2
	 *  출금액 > 5000
	 * -----------------------------------
	 *   1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * -----------------------------------
	 *  선택 > 3
	 *  잔고 확인 > 5000
	 * -----------------------------------
	 *   1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * -----------------------------------
	 * 선택 > 4 
	 * 프로그램 종료
	 * */
	public void method6() {
	
		/*
		 * int money = 0;
		while (true) {
		System.out.println("----------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("----------------------------------");
		System.out.print("선택 > ");
		int num = Integer.parseInt(sc.nextLine());
		if (num == 1) { 
			System.out.print("예금액 > ");
		    int plus = sc.nextInt();
		    money = money + plus;
		    // money += sc.nextInt();
		} else if (num == 2) {
			System.out.print("출금액 > ");
		    int minus = sc.nextInt();
		    money = money - minus;
		 // money -= sc.nextInt();
		} else if (num == 3) {
            System.out.println("잔고확인 > " + money);
        } else if (num == 4) {
			System.out.println("프로그램 종료");
			break;
		} */
		int money = 0;
		boolean check = true;
		while (check) {
		System.out.println("----------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("----------------------------------");
		System.out.print("선택 > ");
		int num = Integer.parseInt(sc.nextLine());
		switch (num)  {
		case 1 : System.out.print("예금액 > ");
		         money += sc.nextInt();
		         break;
		case 2 : System.out.print("출금액 > ");
	             int minus = sc.nextInt();
	             money -= sc.nextInt();
	             break;
		case 3 : System.out.println("잔고확인 > " + money);
		break;
		case 4 : System.out.println("프로그램 종료");
		         check = false;
		         break;
		}
	  }
	}
	


	public static void main(String[] args) {
		D_While d = new D_While();
		d.method6();
	}

}








