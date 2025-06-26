package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		int[] result = new int[4];
		// index : 0 - 2등, 1 - 3등, 2 - 4등, 3 - 5등
		// 1등 당첨 기준이 로또 번호 6개
		// 둘 다 랜덤! 로또번호는 1번!
		// 내 번호는 맞출때까지!! 1~45
		// 정렬이 딱 맞으면 equals로 비교 가능

		// 만약 2등 당첨 보너스 번호 일치 + 5개
		// 3등 - 5개만
		// 4등 - 4개만
		// 5등 - 3개만

		int random = (int) (Math.random() * 45 + 1);

		// win 랜덤숫자 - 고정
		Set<Integer> win = new HashSet<>();
		while (win.size() < 7) {
			win.add((int) (Math.random() * 45 + 1));
		}
		// win : set -> list
		List<Integer> winList = new ArrayList<>(win);
		List<Integer> realwinList = winList.subList(0, 6);
		int bonus = winList.get(6);
		// me 랜덤숫자 - 반복
		int count = 0;
		while (true) {
			count++;
			Set<Integer> me = new HashSet<>();
			while (me.size() < 6) {
				me.add((int) (Math.random() * 45 + 1));
			}
			// me : set -> list
			List<Integer> meList = new ArrayList<>(me);
			// 로또번호 정렬
			Collections.sort(meList);
			System.out.println("로또 번호 : " + realwinList);
			System.out.println("나의 번호 : " + me);
			System.out.println();
			int check = 0;
			for (Integer number : realwinList) {
				if (me.contains(number))
					check++;
			}

			// 나==당첨 종료
			Collections.sort(meList);

			if (me.equals(realwinList)) {
				System.out.println("1등 당첨! 횟수 : " + count);
				for(int i = 0; i < result.length; i++) {
					System.out.println((i+2) +"등 횟수  : " + result[i] + "회 ");
				}
				break;
			} else if (check == 5 && me.contains(bonus)) {
				System.out.println("2등 당첨! 보너스 번호 : " + bonus + ", 횟수 : " + count);
				result[0]++;
			} else if (check == 5) {
				System.out.println("3등  당첨! 횟수 : " + count);
				result[1]++;
			} else if (check == 4) {
				System.out.println("4등  당첨! 횟수 : " + count);
				result[2]++;
			} else if (check == 3) {
				System.out.println("5등  당첨! 횟수 : " + count);
				result[3]++;
			}
		}
	}
}